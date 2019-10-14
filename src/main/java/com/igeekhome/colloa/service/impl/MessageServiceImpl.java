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
            List<MessageInfo> messageInfoList = messageInfoMapper.selectByCondition("%"+condition.getTheme()+"%", condition.getSelf().getEmplCode());
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
            List<MessageInfo> messageInfoList = messageInfoMapper.selectByEmplCondition("%"+condition.getTheme()+"%", emplCodesList, condition.getSelf().getEmplCode());
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

        return null;
    }

    @Override
    public ResultObject queryMessageByMessageCode(String messageCode) {
        return null;
    }

    @Override
    public ResultObject setMessageToRead(String messageCode) {
        return null;
    }

    @Override
    public ResultObject setMessageToStar(String messageCode) {
        return null;
    }

    @Override
    public ResultObject sendMessage(MessageInfo message) {
        return null;
    }

    @Override
    public ResultObject saveMessageToDraft(MessageInfo message) {
        return null;
    }

    @Override
    public ResultObject removeMessage(String messageCode) {
        return null;
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
}
