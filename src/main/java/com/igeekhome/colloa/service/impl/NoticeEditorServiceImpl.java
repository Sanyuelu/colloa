package com.igeekhome.colloa.service.impl;

import com.igeekhome.colloa.domain.NoticeInfo;
import com.igeekhome.colloa.domain.NoticeInfoExample;
import com.igeekhome.colloa.domain.NoticeParticipant;
import com.igeekhome.colloa.enums.NoticeEnum;
import com.igeekhome.colloa.mapper.NoticeInfoMapper;
import com.igeekhome.colloa.mapper.NoticeParticipantMapper;
import com.igeekhome.colloa.service.NoticeEditorService;
import com.igeekhome.colloa.util.CheckNullParameter;
import com.igeekhome.colloa.util.ResultObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NoticeEditorServiceImpl implements NoticeEditorService {

    @Autowired
    private NoticeInfoMapper noticeInfoMapper;
    @Autowired
    private NoticeParticipantMapper noticeParticipantMapper;
    /**
     * @Author muyaqi
     * @param noticeInfo          公告信息
     * @param participantCodeList 参与人的工号
     * @return
     */
    @Override
    public ResultObject saveNotice(NoticeInfo noticeInfo, List<String> participantCodeList) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(noticeInfo)) {
            return ResultObject.fail(500, "参数有误！");
        }
        /**
         * 2.检查公告是否已起草（即是否再次保存）
         */
        if (StringUtils.isNotBlank(noticeInfo.getNoticeCode())){
            //已起草
            NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
            noticeInfoExample.createCriteria()
                    .andNoticeCodeEqualTo(noticeInfo.getNoticeCode());
            NoticeInfo deleteNoticeInfo = new NoticeInfo();
            deleteNoticeInfo.setAvaliable(NoticeEnum.NOT_AVAILABLE.getCode());
            int updateEffected = -1;
            try {
                updateEffected = noticeInfoMapper.updateByExampleSelective(deleteNoticeInfo,noticeInfoExample);
                if (updateEffected <= 0){
                    return ResultObject.fail(500,"公告发布失败！");
                }
            }catch (Exception e){
                return ResultObject.fail(500,e.getMessage());
            }
        }
        /**
         * 3.保存公告（默认起草状态）
         */
        noticeInfo.setNoticeCode(UUID.randomUUID().toString().replace("-", ""));
        noticeInfo.setCreateTime(new Date());
        noticeInfo.setUpdateTime(new Date());
        int effectedNum = -1;
        try {
            effectedNum = noticeInfoMapper.insertSelective(noticeInfo);
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        if (effectedNum <= 0) {
            return ResultObject.fail(500, "公告保存失败！");
        }
        /**
         * 4.检查是否添加参与人
         */
        if (null != participantCodeList && 0 != participantCodeList.size()){
            List<NoticeParticipant> noticeParticipantList = getNoticePatricipantList(noticeInfo.getNoticeCode(),
                    participantCodeList);
            if (null != noticeParticipantList && 0 != noticeParticipantList.size()){
                int noticeParticipantEffected = -1;
                try {
                    noticeParticipantEffected = noticeParticipantMapper.batchInsert(noticeParticipantList);
                    if (noticeParticipantEffected <= 0){
                        return ResultObject.fail(500,"公告保存失败！");
                    }
                }catch (Exception e){
                    return ResultObject.fail(500,e.getMessage());
                }
            }
        }
        /**
         * 5.返回数据
         */
        return ResultObject.ok();
    }

    /**
     * @Author muyaqi
     * @param noticeInfo 公告信息
     * @param participantCodeList
     * @return
     */
    @Override
    public ResultObject publishNotice(NoticeInfo noticeInfo, List<String> participantCodeList) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(noticeInfo)) {
            return ResultObject.fail(500, "参数有误！");
        }
        /**
         * 2.检查公告是否已起草
         */
        if (StringUtils.isNotBlank(noticeInfo.getNoticeCode())){
            //已起草
            NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
            noticeInfoExample.createCriteria()
                    .andNoticeCodeEqualTo(noticeInfo.getNoticeCode());
            NoticeInfo deleteNoticeInfo = new NoticeInfo();
            deleteNoticeInfo.setAvaliable(NoticeEnum.NOT_AVAILABLE.getCode());
            int updateEffected = -1;
            try {
                updateEffected = noticeInfoMapper.updateByExampleSelective(deleteNoticeInfo,noticeInfoExample);
                if (updateEffected <= 0){
                    return ResultObject.fail(500,"公告发布失败！");
                }
            }catch (Exception e){
                return ResultObject.fail(500,e.getMessage());
            }
        }
        /**
         * 3.发布公告
         */
        noticeInfo.setNoticeCode(UUID.randomUUID().toString().replace("-", ""));
        noticeInfo.setCreateTime(new Date());
        noticeInfo.setUpdateTime(new Date());
        noticeInfo.setStatus(NoticeEnum.PUBLISH.getCode());
        int effectedNum = -1;
        try {
            effectedNum = noticeInfoMapper.insertSelective(noticeInfo);
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        if (effectedNum <= 0) {
            return ResultObject.fail(500, "公告发布失败！");
        }
        /**
         * 4.检查是否添加参与人
         */
        if (null != participantCodeList && 0 != participantCodeList.size()){
            List<NoticeParticipant> noticeParticipantList = getNoticePatricipantList(noticeInfo.getNoticeCode(),
                    participantCodeList);
            if (null != noticeParticipantList && 0 != noticeParticipantList.size()){
                int noticeParticipantEffected = -1;
                try {
                    noticeParticipantEffected = noticeParticipantMapper.batchInsert(noticeParticipantList);
                    if (noticeParticipantEffected <= 0){
                        return ResultObject.fail(500,"公告发布失败！");
                    }
                }catch (Exception e){
                    return ResultObject.fail(500,e.getMessage());
                }
            }
        }
        /**
         * 5.返回数据
         */
        return ResultObject.ok();
    }

    /**
     * @Author muyaqi
     * @param noticeInfo          公告信息
     * @param participantCodeList
     * @return
     */
    @Override
    public ResultObject updateNotice(NoticeInfo noticeInfo, List<String> participantCodeList) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(noticeInfo,noticeInfo.getNoticeCode())) {
            return ResultObject.fail(500, "参数有误！");
        }
        /**
         * 2.将原公告清除
         */
        if (StringUtils.isNotBlank(noticeInfo.getNoticeCode())){
            //已发布
            NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
            noticeInfoExample.createCriteria()
                    .andNoticeCodeEqualTo(noticeInfo.getNoticeCode());
            NoticeInfo deleteNoticeInfo = new NoticeInfo();
            deleteNoticeInfo.setAvaliable(NoticeEnum.NOT_AVAILABLE.getCode());
            int updateEffected = -1;
            try {
                updateEffected = noticeInfoMapper.updateByExampleSelective(deleteNoticeInfo,noticeInfoExample);
                if (updateEffected <= 0){
                    return ResultObject.fail(500,"公告更新失败！");
                }
            }catch (Exception e){
                return ResultObject.fail(500,e.getMessage());
            }
        }
        /**
         * 3.添加新公告
         */
        noticeInfo.setNoticeCode(UUID.randomUUID().toString().replace("-", ""));
        noticeInfo.setCreateTime(new Date());
        noticeInfo.setUpdateTime(new Date());
        noticeInfo.setStatus(NoticeEnum.PUBLISH.getCode());
        int effectedNum = -1;
        try {
            effectedNum = noticeInfoMapper.insertSelective(noticeInfo);
        } catch (Exception e) {
            return ResultObject.fail(500, e.getMessage());
        }
        if (effectedNum <= 0) {
            return ResultObject.fail(500, "公告更新失败！");
        }
        /**
         * 4.检查是否添加参与人
         */
        if (null != participantCodeList && 0 != participantCodeList.size()){
            List<NoticeParticipant> noticeParticipantList = getNoticePatricipantList(noticeInfo.getNoticeCode(),
                    participantCodeList);
            if (null != noticeParticipantList && 0 != noticeParticipantList.size()){
                int noticeParticipantEffected = -1;
                try {
                    noticeParticipantEffected = noticeParticipantMapper.batchInsert(noticeParticipantList);
                    if (noticeParticipantEffected <= 0){
                        return ResultObject.fail(500,"公告发布失败！");
                    }
                }catch (Exception e){
                    return ResultObject.fail(500,e.getMessage());
                }
            }
        }
        /**
         * 5.返回数据
         */
        return ResultObject.ok();
    }

    /**
     * @Author muyaqi
     * @param noticeCode 公告编号
     * @return
     */
    @Override
    public ResultObject deleteNotice(String noticeCode) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(noticeCode)) {
            return ResultObject.fail(500, "参数有误！");
        }
        /**
         * 2.将原公告清除
         */
        NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
        noticeInfoExample.createCriteria()
                .andNoticeCodeEqualTo(noticeCode);
        NoticeInfo deleteNoticeInfo = new NoticeInfo();
        deleteNoticeInfo.setAvaliable(NoticeEnum.NOT_AVAILABLE.getCode());
        int updateEffected = -1;
        try {
            updateEffected = noticeInfoMapper.updateByExampleSelective(deleteNoticeInfo,noticeInfoExample);
            if (updateEffected <= 0){
                return ResultObject.fail(500,"公告删除失败！");
            }
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        /**
         * 5.返回数据
         */
        return ResultObject.ok();
    }

    /**
     * 封装 List<NoticeParticipant>
     *
     * @Author muyaqi
     * @param noticeCode
     * @param participantCodeList
     * @return
     */
    private List<NoticeParticipant> getNoticePatricipantList(String noticeCode,List<String> participantCodeList){
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(noticeCode,participantCodeList)
                && 0 != participantCodeList.size()){
            return null;
        }
        /**
         * 2.封装数据
         */
        System.out.println("-------------封装数据-------------");
        List<NoticeParticipant> noticeParticipantList = new ArrayList<>();
        for (String participantCode : participantCodeList){
            if (StringUtils.isBlank(participantCode)){
                continue;
            }
            NoticeParticipant noticeParticipant = new NoticeParticipant();
            noticeParticipant.setNoticeCode(noticeCode);
            noticeParticipant.setParticipantCode(participantCode);
            noticeParticipantList.add(noticeParticipant);
        }
        System.out.println("返回数据----------- ：" + noticeParticipantList);
        /**
         * 3.返回数据
         */
        return noticeParticipantList;
    }
}
