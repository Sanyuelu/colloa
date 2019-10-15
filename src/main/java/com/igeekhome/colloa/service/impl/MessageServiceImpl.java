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
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 消息服务实现类
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageInfoMapper messageInfoMapper;

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    @Override
    public TableDataNode queryUnReadMessage(Integer page, Integer limit, String receiverEmplCode) {

        MessageInfoExample example = new MessageInfoExample();
        // 根据(接收)时间倒序
        example.setOrderByClause("update_time desc");
        example.createCriteria()
                .andReceiverCodeEqualTo(receiverEmplCode) // 接受者工号
                .andReadStatusEqualTo(MessageStatusEnum.UNREAD.getCode()) // 未读信息
                .andSendStatusEqualTo(MessageStatusEnum.SENT.getCode()) // 已发送消息
                .andReceiverAvailableEqualTo(MessageStatusEnum.RECEIVER_IS_AVAILABLE.getCode()) // 对接受者可见
                .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode()); // 消息有效
        // 开启分页
        PageHelper.startPage(page, limit);
        // 分页后查询的结果
        List<MessageInfo> messageInfoList = messageInfoMapper.selectByExample(example);
        // 消息发送者的工号集合
        Set<String> senderCodes = messageInfoList.stream().map(messageInfo -> messageInfo.getSenderCode())
                .collect(Collectors.toSet());
        // 同时添加消息接收者工号
        senderCodes.add(receiverEmplCode);

        return TableDataNodeUtil.getTableDataNode(getMessageInfoDTOList(messageInfoList, receiverEmplCode, senderCodes));
    }

    @Override
    public TableDataNode queryReadMessage(Integer page, Integer limit, String receiverEmplCode) {

        MessageInfoExample example = new MessageInfoExample();
        // 排序
        example.setOrderByClause("update_time desc");
        example.createCriteria()
                .andReceiverCodeEqualTo(receiverEmplCode)
                .andReadStatusEqualTo(MessageStatusEnum.READ.getCode())
                .andSendStatusEqualTo(MessageStatusEnum.SENT.getCode())
                .andReceiverAvailableEqualTo(MessageStatusEnum.RECEIVER_IS_AVAILABLE.getCode())
                .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());

        // 开启分页
        PageHelper.startPage(page, limit);
        List<MessageInfo> messageInfoList = messageInfoMapper.selectByExample(example);
        // 消息发送者的工号集合
        Set<String> senderCodes = messageInfoList.stream().map(messageInfo -> messageInfo.getSenderCode())
                .collect(Collectors.toSet());
        // 同时添加消息接收者工号
        senderCodes.add(receiverEmplCode);
        return TableDataNodeUtil.getTableDataNode(getMessageInfoDTOList(messageInfoList, receiverEmplCode, senderCodes));
    }

    @Override
    public TableDataNode querySentMessage(Integer page, Integer limit, String senderEmplCode) {

        MessageInfoExample example = new MessageInfoExample();
        example.setOrderByClause("update_time desc");
        example.createCriteria()
                .andSenderCodeEqualTo(senderEmplCode)
                .andSendStatusEqualTo(MessageStatusEnum.SENT.getCode())
                .andSenderAvailableEqualTo(MessageStatusEnum.SENDER_IS_AVAILABLE.getCode())
                .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
        // 开启分页
        PageHelper.startPage(page, limit);
        List<MessageInfo> messageInfoList = messageInfoMapper.selectByExample(example);

        // 消息接收者的工号集合
        Set<String> receiverCodes = messageInfoList.stream().map(messageInfo -> messageInfo.getReceiverCode())
                .collect(Collectors.toSet());
        // 同时添加消息发送者工号
        receiverCodes.add(senderEmplCode);
        return TableDataNodeUtil.getTableDataNode(getMessageInfoDTOList(messageInfoList, senderEmplCode, receiverCodes));
    }

    @Override
    public TableDataNode queryDraftMessage(Integer page, Integer limit, String senderEmplCode) {

        MessageInfoExample example = new MessageInfoExample();
        example.setOrderByClause("update_time desc");
        example.createCriteria()
                .andSenderCodeEqualTo(senderEmplCode)
                .andSendStatusEqualTo(MessageStatusEnum.DRAFT.getCode())
                .andSenderAvailableEqualTo(MessageStatusEnum.SENDER_IS_AVAILABLE.getCode())
                .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());

        // 开启分页
        PageHelper.startPage(page, limit);
        List<MessageInfo> messageInfoList = messageInfoMapper.selectByExample(example);
        // 消息接收者的工号集合
        Set<String> receiverCodes = messageInfoList.stream().map(messageInfo -> messageInfo.getReceiverCode())
                .collect(Collectors.toSet());
        // 同时添加消息发送者工号
        receiverCodes.add(senderEmplCode);
        return TableDataNodeUtil.getTableDataNode(getMessageInfoDTOList(messageInfoList, senderEmplCode, receiverCodes));
    }

    @Override
    public TableDataNode queryStarMessage(Integer page, Integer limit, String receiverEmplCode) {

        MessageInfoExample example = new MessageInfoExample();
        example.setOrderByClause("update_time desc");
        example.createCriteria()
                .andReceiverCodeEqualTo(receiverEmplCode)
                .andIsStarEqualTo(MessageStatusEnum.IS_STAR.getCode())
                .andSendStatusEqualTo(MessageStatusEnum.SENT.getCode())
                .andReceiverAvailableEqualTo(MessageStatusEnum.RECEIVER_IS_AVAILABLE.getCode())
                .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
        PageHelper.startPage(page, limit);
        List<MessageInfo> messageInfoList = messageInfoMapper.selectByExample(example);
        // 消息接收者的工号集合
        Set<String> senderCodes = messageInfoList.stream().map(messageInfo -> messageInfo.getReceiverCode())
                .collect(Collectors.toSet());
        // 同时添加消息发送者工号
        senderCodes.add(receiverEmplCode);
        return TableDataNodeUtil.getTableDataNode(getMessageInfoDTOList(messageInfoList, receiverEmplCode, senderCodes));
    }

    @Override
    public TableDataNode querySelfMessageByCondition(Integer page, Integer limit, MessageInfoDTO condition) {

        if (condition.getEmployee1() == null || StringUtils.isBlank(condition.getEmployee1().getName())) {
            // 没有输入发送人/接收人条件
            PageHelper.startPage(page, limit);
            List<MessageInfo> messageInfoList = messageInfoMapper.selectByCondition("%" + condition.getTheme() + "%", condition.getSelf().getEmplCode());
            // 与自己相关的消息的
            HashSet<String> emplCodesSet = new HashSet<>();
            for (MessageInfo info : messageInfoList) {
                emplCodesSet.add(info.getSenderCode());
                emplCodesSet.add(info.getReceiverCode());
            }
            PageHelper.clearPage();

            return TableDataNodeUtil.getTableDataNode(getMessageInfoDTOList(messageInfoList, condition.getSelf().getEmplCode(), emplCodesSet));

        } else {
            // 输入接受者或发送者名称
            EmployeeInfoExample example = new EmployeeInfoExample();
            example.createCriteria()
                    .andNameLike("%" + condition.getEmployee1().getName() + "%");
            List<EmployeeInfo> employeeInfoList = employeeInfoMapper.selectByExample(example);

            Set<String> emplCodesSet = employeeInfoList.stream().map(employeeInfo -> employeeInfo.getEmplCode())
                    .collect(Collectors.toSet());
            // 添加自己
            emplCodesSet.add(condition.getSelf().getEmplCode());

            ArrayList<String> emplCodesList = new ArrayList<>();
            emplCodesList.addAll(emplCodesSet);

            PageHelper.startPage(page, limit);
            List<MessageInfo> messageInfoList = messageInfoMapper.selectByEmplCondition("%" + condition.getTheme() + "%", emplCodesList, condition.getSelf().getEmplCode());
            PageHelper.clearPage();
            // 与自己相关的消息的
            HashSet<String> emplCodes = new HashSet<>();
            for (MessageInfo info : messageInfoList) {
                emplCodesSet.add(info.getSenderCode());
                emplCodesSet.add(info.getReceiverCode());
            }
            return TableDataNodeUtil.getTableDataNode(getMessageInfoDTOList(messageInfoList, condition.getSelf().getEmplCode(), emplCodesSet));
        }
    }

    @Override
    public TableDataNode queryMessageByCondition(Integer page, Integer limit, MessageInfoDTO condition) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(page, limit, condition)) {
            return TableDataNode.ok(0, null);
        }
        /**
         * 2.判断是否根据收件人(employee1)和发件人(employee2)查询
         */
        String employee1Name = null;
        if (null != condition.getEmployee1() && null != condition.getEmployee1()) {
            employee1Name = condition.getEmployee1().getName();
        }
        List<EmployeeInfo> employee1List = null;
        if (null != employee1Name && !"".equals(employee1Name)) {
            EmployeeInfoExample employee1Example = new EmployeeInfoExample();
            employee1Example.createCriteria()
                    .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode())
                    .andNameLike("%" + employee1Name + "%");
            employee1List = employeeInfoMapper.selectByExample(employee1Example);
        }
        String employee2Name = null;
        if (null != condition.getEmployee2() && null != condition.getEmployee2()) {
            employee2Name = condition.getEmployee2().getName();
        }
        List<EmployeeInfo> employee2List = null;
        if (null != employee2Name && !"".equals(employee2Name)) {
            EmployeeInfoExample employee2Example = new EmployeeInfoExample();
            employee2Example.createCriteria()
                    .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode())
                    .andNameLike("%" + employee2Name + "%");
            employee2List = employeeInfoMapper.selectByExample(employee2Example);
        }
        /**
         * 3.查询消息列表
         */
        PageHelper.startPage(page, limit);
        MessageInfoExample messageInfoExample = new MessageInfoExample();
        messageInfoExample.setOrderByClause("update_time DESC");
        MessageInfoExample.Criteria messageCriteria = messageInfoExample.createCriteria();
        messageCriteria.andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode())
                .andThemeLike("%" + condition.getTheme() + "%");
        if (null != employee1List && 0 != employee1List.size()) {
            List<String> emplCodeList1 = getEmployeeCode(employee1List);
            messageCriteria.andReceiverCodeIn(emplCodeList1);
        }
        if (null != employee2List && 0 != employee2List.size()) {
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
        if (CheckNullParameter.haveNullParameter(messageCode)) {
            return ResultObject.fail(500, "参数有误！");
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
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        if (null == messageInfoList || 0 == messageInfoList.size()) {
            return ResultObject.fail(500, "该消息不存在!");
        }
        MessageInfo messageInfo = messageInfoList.get(0);
        EmployeeInfo sender = null;
        if (null != messageInfo.getSenderCode()) {
            try {
                EmployeeInfoExample senderExample = new EmployeeInfoExample();
                EmployeeInfoExample.Criteria senderExampleCriteria = senderExample.createCriteria();
                senderExampleCriteria.andEmplCodeEqualTo(messageInfo.getSenderCode())
                        .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
                List<EmployeeInfo> senderList = employeeInfoMapper.selectByExample(senderExample);
                if (null != senderList && 0 != senderList.size()) {
                    sender = senderList.get(0);
                }
            } catch (Exception e) {
                return ResultObject.fail(500, e.getMessage());
            }
        }
        EmployeeInfo receiver = null;
        if (null != messageInfo.getReceiverCode()) {
            try {
                EmployeeInfoExample receiverExample = new EmployeeInfoExample();
                EmployeeInfoExample.Criteria receiverExampleCriteria = receiverExample.createCriteria();
                receiverExampleCriteria.andEmplCodeEqualTo(messageInfo.getReceiverCode())
                        .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
                List<EmployeeInfo> receiverList = employeeInfoMapper.selectByExample(receiverExample);
                if (null != receiverList && 0 != receiverList.size()) {
                    receiver = receiverList.get(0);
                }
            } catch (Exception e) {
                return ResultObject.fail(500, e.getMessage());
            }
        }
        /**
         * 3.封装 MessageInfoDTO 对象
         */
        MessageInfoDTO messageInfoDTO = new MessageInfoDTO();
        BeanUtils.copyProperties(messageInfo, messageInfoDTO);
        if (null != sender) {
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
        if (CheckNullParameter.haveNullParameter(messageCode)) {
            return ResultObject.fail(500, "参数有误！");
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
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        if (null == messageInfoList || 0 == messageInfoList.size()) {
            return ResultObject.fail(500, "该消息不存在!");
        }
        /**
         * 3.更新消息为已读
         */
        MessageInfo messageInfo = messageInfoList.get(0);
        messageInfo.setReadStatus(MessageStatusEnum.READ.getCode());
        int effectedNum = -1;
        try {
            effectedNum = messageInfoMapper.updateByExample(messageInfo, messageInfoExample);
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        /**
         * 4.返回状态
         */
        if (effectedNum <= 0) {
            return ResultObject.fail(500, "更新失败！");
        }
        return ResultObject.ok();
        //return null;
    }

    @Override
    public ResultObject setMessageToStar(String messageCode) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(messageCode)) {
            return ResultObject.fail(500, "参数有误！");
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
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        if (null == messageInfoList || 0 == messageInfoList.size()) {
            return ResultObject.fail(500, "该消息不存在!");
        }
        /**
         * 3.更新消息为星标消息 isStar = 1
         */
        MessageInfo messageInfo = messageInfoList.get(0);
        messageInfo.setIsStar(MessageStatusEnum.IS_STAR.getCode());
        int effectedNum = -1;
        try {
            effectedNum = messageInfoMapper.updateByExample(messageInfo, messageInfoExample);
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        /**
         * 4.返回状态
         */
        if (effectedNum <= 0) {
            return ResultObject.fail(500, "更新失败！");
        }
        return ResultObject.ok();
    }

    @Override
    public ResultObject sendMessage(MessageInfo message) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(message, message.getSenderCode(), message.getReceiverCode())) {
            return ResultObject.fail(500, "参数有误！");
        }
        /**
         * 2.检查消息是否已创建
         *      (1).消息未创建，需直接发送
         *      (2).消息已创建，保存在草稿箱，检查草稿箱
         */
        boolean isExists = true;
        if (null == message.getMessageCode()) {
            isExists = false;
        } else {
            MessageInfoExample messageInfoExample = new MessageInfoExample();
            MessageInfoExample.Criteria criteria = messageInfoExample.createCriteria();
            criteria.andMessageCodeEqualTo(message.getMessageCode());
            criteria.andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode());
            List<MessageInfo> messageInfoList = null;
            try {
                messageInfoList = messageInfoMapper.selectByExample(messageInfoExample);
            } catch (Exception e) {
                return ResultObject.fail(500, e.getMessage());
            }
            if (null == messageInfoList || 0 == messageInfoList.size()) {
                return ResultObject.fail(500, "该消息不存在!");
            }
        }
        /**
         * 3.发送消息
         *      (1).消息未创建，直接发送，插入消息
         *      (2).消息已创建，修改状态为已发送，进行更新
         */
        if (!isExists) {
            message.setMessageCode(UUID.randomUUID().toString().replace("-", ""));
            message.setCreateTime(new Date());
            message.setUpdateTime(new Date());
            message.setSendStatus(MessageStatusEnum.SENT.getCode());
            /**
             * 添加消息到数据库
             */
            int effectedNum = -1;
            try {
                effectedNum = messageInfoMapper.insertSelective(message);
            } catch (Exception e) {
                return ResultObject.fail(500, e.getMessage());
            }
            if (effectedNum <= 0) {
                return ResultObject.fail(500, "发送失败！");
            }
        } else {
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
                effectedNum = messageInfoMapper.updateByExampleSelective(message, messageInfoExample);
            } catch (Exception e) {
                return ResultObject.fail(500, e.getMessage());
            }
            if (effectedNum <= 0) {
                return ResultObject.fail(500, "发送失败！");
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
        if (CheckNullParameter.haveNullParameter(message, message.getSenderCode())) {
            return ResultObject.fail(500, "参数有误！");
        }
        /**
         * 2.添加消息到草稿箱
         */
        message.setMessageCode(UUID.randomUUID().toString().replace("-", ""));
        message.setCreateTime(new Date());
        message.setUpdateTime(new Date());
        message.setSendStatus(MessageStatusEnum.DRAFT.getCode());
        int effectedNum = -1;
        try {
            effectedNum = messageInfoMapper.insertSelective(message);
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        /**
         * 3.返回状态
         */
        if (effectedNum <= 0) {
            return ResultObject.fail(500, "保存到草稿箱失败！");
        }
        return ResultObject.ok();
    }

    @Override
    public ResultObject removeMessage(String messageCode, Integer deleteTypeCode) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(messageCode, deleteTypeCode)) {
            return ResultObject.fail(500, "参数有误！");
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
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        if (null == messageInfoList || 0 == messageInfoList.size()) {
            return ResultObject.fail(500, "该消息不存在!");
        }
        /**
         * 3.判断是发送方删除还是接收方删除,然后进行删除
         */
        MessageInfo messageInfo = messageInfoList.get(0);
        if (MessageStatusEnum.SENDER_DELETE.getCode() == deleteTypeCode) {
            messageInfo.setSenderAvailable(MessageStatusEnum.SENDER_NOT_AVAILABLE.getCode());
        } else if (MessageStatusEnum.RECEIVER_DELETE.getCode() == deleteTypeCode) {
            messageInfo.setReceiverAvailable(MessageStatusEnum.RECEIVER_NOT_AVAILABLE.getCode());
        }
        int effectedNum = -1;
        try {
            effectedNum = messageInfoMapper.updateByExample(messageInfo, messageInfoExample);
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        /**
         * 4.返回状态
         */
        if (effectedNum <= 0) {
            return ResultObject.fail(500, "删除失败！");
        }
        return ResultObject.ok();
    }

    /**
     * 封装消息数据[将消息内容和消息发送/接收双方进行封装]
     *
     * @param messageInfoList
     * @param emplCode        接收者/发送者工号
     * @param emplCodeSet     员工工号集合
     * @return
     */
    private List<MessageInfoDTO> getMessageInfoDTOList(List<MessageInfo> messageInfoList, String emplCode, Set<String> emplCodeSet) {

        // 消息发送者员工编号列表
        ArrayList<String> emplCodeList = new ArrayList<>();
        emplCodeList.addAll(emplCodeSet);
        // 根据工号检索员工信息
        EmployeeInfoExample employeeInfoExample = new EmployeeInfoExample();
        employeeInfoExample.createCriteria()
                .andEmplCodeIn(emplCodeList);
        List<EmployeeInfo> employeeInfoList = employeeInfoMapper.selectByExample(employeeInfoExample);

        // 将员工信息列表转为<员工编号,员工信息>的Map集合
        Map<String, EmployeeInfo> employeeInfoMap = employeeInfoList.stream().
                collect(Collectors.toMap(employeeInfo -> employeeInfo.getEmplCode(), employeeInfo -> employeeInfo));

        // 封装到messageInfoDTOList
        List<MessageInfoDTO> messageInfoDTOList = messageInfoList.stream().map(messageInfo -> {
            MessageInfoDTO infoDTO = new MessageInfoDTO();
            BeanUtils.copyProperties(messageInfo, infoDTO);
            // 填充消息发送者
            infoDTO.setEmployee1(employeeInfoMap.get(messageInfo.getSenderCode()));
            // 填充消息接受者
            infoDTO.setEmployee2(employeeInfoMap.get(messageInfo.getReceiverCode()));
            return infoDTO;
        }).collect(Collectors.toList());
        return messageInfoDTOList;
    }

    /**
     * 获取 employeeList 的 emplCode 列表
     *
     * @param employeeInfoList
     * @return
     */
    private List<String> getEmployeeCode(List<EmployeeInfo> employeeInfoList) {
        List<String> emplCodeList = new ArrayList<>();
        for (EmployeeInfo employeeInfo : employeeInfoList) {
            emplCodeList.add(employeeInfo.getEmplCode());
        }
        return emplCodeList;
    }

    /**
     * 封装消息数据2
     *
     * @param messageInfoList
     * @return
     */
    private List<MessageInfoDTO> getMessageInfoDTOList2(List<MessageInfo> messageInfoList) {
        /**
         *
         */
        Set<String> emplCodeSet = new HashSet<>();
        for (MessageInfo messageInfo : messageInfoList) {
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
        Map<String, EmployeeInfo> employeeInfoMap = new HashMap<>();
        for (EmployeeInfo employeeInfo : employeeInfoList) {
            employeeInfoMap.put(employeeInfo.getEmplCode(), employeeInfo);
        }
        /**
         *
         */
        List<MessageInfoDTO> messageInfoDTOList = new ArrayList<>();
        for (MessageInfo messageInfo : messageInfoList) {
            MessageInfoDTO messageInfoDTO = new MessageInfoDTO();
            BeanUtils.copyProperties(messageInfo, messageInfoDTO);
            messageInfoDTO.setEmployee1(employeeInfoMap.get(messageInfo.getReceiverCode()));
            messageInfoDTO.setEmployee2(employeeInfoMap.get(messageInfo.getSenderCode()));
            messageInfoDTOList.add(messageInfoDTO);
        }
        return messageInfoDTOList;
    }
}
