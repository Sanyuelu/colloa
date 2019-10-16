package com.igeekhome.colloa.enums;

public enum DictCategoryEnum {

    // 字典类:[1:公司类,2:部门类,3:职务类,4:服务类(外部通讯录),5:公告类别]

    COMPANY(1, "公司"),
    DEPARTMENT(2, "部门"),
    POSITION(3, "职务"),
    EXTERNAL(4, "外部通讯录"),
    NOTICE_TYPE(5, "公告类别"),
    IS_AVAILABLE(1, "有效"),
    NOT_AVAILABLE(0, "无效"),
    ;

    private String categoryName;
    private Integer dictTypeId;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getDictTypeId() {
        return dictTypeId;
    }

    public void setDictTypeId(Integer dictTypeId) {
        this.dictTypeId = dictTypeId;
    }

    private DictCategoryEnum(Integer dictTypeId,
                             String categoryName) {
        this.dictTypeId = dictTypeId;
        this.categoryName = categoryName;
    }
}
