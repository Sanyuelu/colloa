package com.igeekhome.colloa.service.impl;

import com.github.pagehelper.PageHelper;
import com.igeekhome.colloa.domain.EmployeeInfo;
import com.igeekhome.colloa.domain.EmployeeInfoExample;
import com.igeekhome.colloa.domain.MessageInfo;
import com.igeekhome.colloa.domain.MessageInfoExample;
import com.igeekhome.colloa.dto.MessageInfoDTO;
import com.igeekhome.colloa.enums.MessageStatusEnum;
import com.igeekhome.colloa.mapper.EmployeeInfoMapper;
import com.igeekhome.colloa.mapper.MessageInfoMapper;
import com.igeekhome.colloa.service.MessageService;
import com.igeekhome.colloa.util.CheckNullParameter;
import com.igeekhome.colloa.util.ResultObject;
import com.igeekhome.colloa.util.TableDataNode;
import com.igeekhome.colloa.util.TableDataNodeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageInfoMapper messageInfoMapper;
    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;


    @Override
    public TableDataNode querySelfMessageByCondition(Integer page, Integer limit, MessageInfoDTO condition) {
        return null;
    }

    @Override
    public TableDataNode queryMessageByCondition(Integer page, Integer limit, MessageInfoDTO condition) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(page,limit,condition)){
            return TableDataNode.ok(0,null);
        }
        /**
         * 2.判断是否根据收件人(employee1)和发件人(employee2)查询
         */
        String employee1Name = null;
        if(null != condition.getEmployee1() && null != condition.getEmployee1()){
            employee1Name = condition.getEmployee1().getName();
        }
        List<EmployeeInfo> employee1List = null;
        if (null != employee1Name && !"".equals(employee1Name)){
            EmployeeInfoExample employee1Example = new EmployeeInfoExample();
            employee1Example.createCriteria()
                    .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode())
                    .andNameLike("%" + employee1Name + "%");
            employee1List = employeeInfoMapper.selectByExample(employee1Example);
        }
        String employee2Name = null;
        if(null != condition.getEmployee2() && null != condition.getEmployee2()){
            employee2Name = condition.getEmployee2().getName();
        }
        List<EmployeeInfo> employee2List = null;
        if (null != employee2Name && !"".equals(employee2Name)){
            EmployeeInfoExample employee2Example = new EmployeeInfoExample();
            employee2Example.createCriteria()
                    .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode())
                    .andNameLike("%" + employee2Name + "%");
            employee2List = employeeInfoMapper.selectByExample(employee2Example);
        }
        /**
         * 3.查询消息列表
         */
        PageHelper.startPage(page,limit);
        MessageInfoExample messageInfoExample = new MessageInfoExample();
        messageInfoExample.setOrderByClause("update_time DESC");
        MessageInfoExample.Criteria messageCriteria = messageInfoExample.createCriteria();
        messageCriteria.andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode())
                .andThemeLike("%" + condition.getTheme() + "%");
        if (null != employee1List && 0 != employee1List.size()){
            List<String> emplCodeList1 = getEmployeeCode(employee1List);
            messageCriteria.andReceiverCodeIn(emplCodeList1);
        }
        if (null != employee2List && 0 != employee2List.size()){
            List<String> emplCodeList2 = getEmployeeCode(employee2List);
            messageCriteria.andSenderCodeIn(emplCodeList2);
        }
        List<MessageInfo> messageInfoList = messageInfoMapper.selectByExample(messageInfoExample);
        /**
         * 4.封装数据
         */
        List<MessageInfoDTO> messageInfoDTOList = getMessageInfoDTOList2(messageInfoList);
        /**
         * 5.返回数据
         */
        return TableDataNodeUtil.getTableDataNode(messageInfoDTOList);
    }

    @Override
    public ResultObject queryMessageByMessageCode(String messageCode) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(messageCode)){
            return ResultObject.fail(500,"参数有误！");
        }
        /**
         * 2.条件查询
         */
        MessageInfoExample messageInfoExample = new MessageInfoExample();
        MessageInfoExample.Criteria criteria = messageInfoExample.createCriteria();
        criteria.andMessageCodeEqualTo(messageCode);
        criteria.andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
        List<MessageInfo> messageInfoList = null;
        try {
            messageInfoList = messageInfoMapper.selectByExample(messageInfoExample);
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        if(null == messageInfoList || 0 == messageInfoList.size()){
            return ResultObject.fail(500,"该消息不存在!");
        }
        MessageInfo messageInfo = messageInfoList.get(0);
        EmployeeInfo sender = null;
        if (null != messageInfo.getSenderCode()){
            try {
                EmployeeInfoExample senderExample = new EmployeeInfoExample();
                EmployeeInfoExample.Criteria senderExampleCriteria = senderExample.createCriteria();
                senderExampleCriteria.andEmplCodeEqualTo(messageInfo.getSenderCode())
                        .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
                List<EmployeeInfo> senderList = employeeInfoMapper.selectByExample(senderExample);
                if(null != senderList && 0 != senderList.size()){
                    sender = senderList.get(0);
                }
            }catch (Exception e){
                return ResultObject.fail(500,e.getMessage());
            }
        }
        EmployeeInfo receiver = null;
        if (null != messageInfo.getReceiverCode()){
            try {
                EmployeeInfoExample receiverExample = new EmployeeInfoExample();
                EmployeeInfoExample.Criteria receiverExampleCriteria = receiverExample.createCriteria();
                receiverExampleCriteria.andEmplCodeEqualTo(messageInfo.getReceiverCode())
                        .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
                List<EmployeeInfo> receiverList = employeeInfoMapper.selectByExample(receiverExample);
                if(null != receiverList && 0 != receiverList.size()){
                    receiver = receiverList.get(0);
                }
            }catch (Exception e){
                return ResultObject.fail(500,e.getMessage());
            }
        }
        /**
         * 3.封装 MessageInfoDTO 对象
         */
        MessageInfoDTO messageInfoDTO = new MessageInfoDTO();
        BeanUtils.copyProperties(messageInfo,messageInfoDTO);
        if (null != sender){
            messageInfoDTO.setEmployee1(receiver);
            messageInfoDTO.setEmployee2(sender);
        }
        return ResultObject.ok(messageInfoDTO);
    }

    @Override
    public ResultObject setMessageToRead(String messageCode) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(messageCode)){
            return ResultObject.fail(500,"参数有误！");
        }
        /**
         * 2.检查消息是否存在
         */
        MessageInfoExample messageInfoExample = new MessageInfoExample();
        MessageInfoExample.Criteria criteria = messageInfoExample.createCriteria();
        criteria.andMessageCodeEqualTo(messageCode);
        criteria.andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
        List<MessageInfo> messageInfoList = null;
        try {
            messageInfoList = messageInfoMapper.selectByExample(messageInfoExample);
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        if(null == messageInfoList || 0 == messageInfoList.size()){
            return ResultObject.fail(500,"该消息不存在!");
        }
        /**
         * 3.更新消息为已读
         */
        MessageInfo messageInfo = messageInfoList.get(0);
        messageInfo.setReadStatus(MessageStatusEnum.READ.getCode());
        int effectedNum = -1;
        try {
            effectedNum = messageInfoMapper.updateByExample(messageInfo,messageInfoExample);
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        /**
         * 4.返回状态
         */
        if (effectedNum <= 0){
            return ResultObject.fail(500,"更新失败！");
        }
        return ResultObject.ok();
        //return null;
    }

    @Override
    public ResultObject setMessageToStar(String messageCode) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(messageCode)){
            return ResultObject.fail(500,"参数有误！");
        }
        /**
         * 2.检查消息是否存在
         */
        MessageInfoExample messageInfoExample = new MessageInfoExample();
        MessageInfoExample.Criteria criteria = messageInfoExample.createCriteria();
        criteria.andMessageCodeEqualTo(messageCode);
        criteria.andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
        List<MessageInfo> messageInfoList = null;
        try {
            messageInfoList = messageInfoMapper.selectByExample(messageInfoExample);
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        if(null == messageInfoList || 0 == messageInfoList.size()){
            return ResultObject.fail(500,"该消息不存在!");
        }
        /**
         * 3.更新消息为星标消息 isStar = 1
         */
        MessageInfo messageInfo = messageInfoList.get(0);
        messageInfo.setIsStar(MessageStatusEnum.IS_STAR.getCode());
        int effectedNum = -1;
        try {
            effectedNum = messageInfoMapper.updateByExample(messageInfo,messageInfoExample);
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        /**
         * 4.返回状态
         */
        if (effectedNum <= 0){
            return ResultObject.fail(500,"更新失败！");
        }
        return ResultObject.ok();
    }

    @Override
    public ResultObject sendMessage(MessageInfo message) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(message,message.getSenderCode(),message.getReceiverCode())){
            return ResultObject.fail(500,"参数有误！");
        }
        /**
         * 2.检查消息是否已创建
         *      (1).消息未创建，需直接发送
         *      (2).消息已创建，保存在草稿箱，检查草稿箱
         */
        boolean isExists = true;
        if (null == message.getMessageCode()){
            isExists = false;
        }else {
            MessageInfoExample messageInfoExample = new MessageInfoExample();
            MessageInfoExample.Criteria criteria = messageInfoExample.createCriteria();
            criteria.andMessageCodeEqualTo(message.getMessageCode());
            criteria.andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
            List<MessageInfo> messageInfoList = null;
            try {
                messageInfoList = messageInfoMapper.selectByExample(messageInfoExample);
            }catch (Exception e){
                return ResultObject.fail(500,e.getMessage());
            }
            if(null == messageInfoList || 0 == messageInfoList.size()){
                return ResultObject.fail(500,"该消息不存在!");
            }
        }
        /**
         * 3.发送消息
         *      (1).消息未创建，直接发送，插入消息
         *      (2).消息已创建，修改状态为已发送，进行更新
         */
        if (!isExists){
            message.setMessageCode(UUID.randomUUID().toString().replace("-",""));
            message.setCreateTime(new Date());
            message.setUpdateTime(new Date());
            message.setSendStatus(MessageStatusEnum.SENT.getCode());
            /**
             * 添加消息到数据库
             */
            int effectedNum = -1;
            try {
                effectedNum = messageInfoMapper.insertSelective(message);
            }catch (Exception e){
                return ResultObject.fail(500,e.getMessage());
            }
            if (effectedNum <= 0){
                return ResultObject.fail(500,"发送失败！");
            }
        }else {
            /**
             * 更新消息，且状态为已发送
             */
            message.setUpdateTime(new Date());
            message.setSendStatus(MessageStatusEnum.SENT.getCode());
            int effectedNum = -1;
            try {
                MessageInfoExample messageInfoExample = new MessageInfoExample();
                MessageInfoExample.Criteria criteria = messageInfoExample.createCriteria();
                criteria.andMessageCodeEqualTo(message.getMessageCode());
                effectedNum = messageInfoMapper.updateByExampleSelective(message,messageInfoExample);
            }catch (Exception e){
                return ResultObject.fail(500,e.getMessage());
            }
            if (effectedNum <= 0){
                return ResultObject.fail(500,"发送失败！");
            }
        }
        /**
         * 4.返回状态
         */
        return ResultObject.ok();
    }

    @Override
    public ResultObject saveMessageToDraft(MessageInfo message) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(message,message.getSenderCode())){
            return ResultObject.fail(500,"参数有误！");
        }
        /**
         * 2.添加消息到草稿箱
         */
        message.setMessageCode(UUID.randomUUID().toString().replace("-",""));
        message.setCreateTime(new Date());
        message.setUpdateTime(new Date());
        message.setSendStatus(MessageStatusEnum.DRAFT.getCode());
        int effectedNum = -1;
        try {
            effectedNum = messageInfoMapper.insertSelective(message);
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        /**
         * 3.返回状态
         */
        if (effectedNum <= 0){
            return ResultObject.fail(500,"保存到草稿箱失败！");
        }
        return ResultObject.ok();
    }

    @Override
    public ResultObject removeMessage(String messageCode,Integer deleteTypeCode) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(messageCode,deleteTypeCode)){
            return ResultObject.fail(500,"参数有误！");
        }
        /**
         * 2.检查消息是否存在
         */
        MessageInfoExample messageInfoExample = new MessageInfoExample();
        MessageInfoExample.Criteria criteria = messageInfoExample.createCriteria();
        criteria.andMessageCodeEqualTo(messageCode);
        criteria.andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
        List<MessageInfo> messageInfoList = null;
        try {
            messageInfoList = messageInfoMapper.selectByExample(messageInfoExample);
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        if(null == messageInfoList || 0 == messageInfoList.size()){
            return ResultObject.fail(500,"该消息不存在!");
        }
        /**
         * 3.判断是发送方删除还是接收方删除,然后进行删除
         */
        MessageInfo messageInfo = messageInfoList.get(0);
        if (MessageStatusEnum.SENDER_DELETE.getCode() == deleteTypeCode){
            messageInfo.setSenderAvailable(MessageStatusEnum.SENDER_NOT_AVAILABLE.getCode());
        }else if (MessageStatusEnum.RECEIVER_DELETE.getCode() == deleteTypeCode){
            messageInfo.setReceiverAvailable(MessageStatusEnum.RECEIVER_NOT_AVAILABLE.getCode());
        }
        int effectedNum = -1;
        try {
            effectedNum = messageInfoMapper.updateByExample(messageInfo,messageInfoExample);
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        /**
         * 4.返回状态
         */
        if (effectedNum <= 0){
            return ResultObject.fail(500,"删除失败！");
        }
        return ResultObject.ok();
    }

    /**
     * 获取 employeeList 的 emplCode 列表
     * @param employeeInfoList
     * @return
     */
    private List<String> getEmployeeCode(List<EmployeeInfo> employeeInfoList){
        List<String> emplCodeList = new ArrayList<>();
        for (EmployeeInfo employeeInfo : employeeInfoList){
            emplCodeList.add(employeeInfo.getEmplCode());
        }
        return emplCodeList;
    }

    /**
     * 封装消息数据2
     * @param messageInfoList
     * @return
     */
    private List<MessageInfoDTO> getMessageInfoDTOList2(List<MessageInfo> messageInfoList){
        /**
         *
         */
        Set<String> emplCodeSet = new HashSet<>();
        for(MessageInfo messageInfo : messageInfoList){
            emplCodeSet.add(messageInfo.getSenderCode());
            emplCodeSet.add(messageInfo.getReceiverCode());
        }
        List<String> emplCodeList = new ArrayList<>();
        emplCodeList.addAll(emplCodeSet);
        EmployeeInfoExample employeeInfoExample = new EmployeeInfoExample();
        EmployeeInfoExample.Criteria employeeInfoExampleCriteria = employeeInfoExample.createCriteria();
        employeeInfoExampleCriteria.andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode())
                .andEmplCodeIn(emplCodeList);
        List<EmployeeInfo> employeeInfoList = employeeInfoMapper.selectByExample(employeeInfoExample);
        /**
         *
         */
        Map<String,EmployeeInfo> employeeInfoMap = new HashMap<>();
        for (EmployeeInfo employeeInfo : employeeInfoList){
           employeeInfoMap.put(employeeInfo.getEmplCode(),employeeInfo);
        }
        /**
         *
         */
        List<MessageInfoDTO> messageInfoDTOList = new ArrayList<>();
        for (MessageInfo messageInfo : messageInfoList){
            MessageInfoDTO messageInfoDTO = new MessageInfoDTO();
            BeanUtils.copyProperties(messageInfo,messageInfoDTO);
            messageInfoDTO.setEmployee1(employeeInfoMap.get(messageInfo.getReceiverCode()));
            messageInfoDTO.setEmployee2(employeeInfoMap.get(messageInfo.getSenderCode()));
            messageInfoDTOList.add(messageInfoDTO);
        }
        return messageInfoDTOList;
    }
}
