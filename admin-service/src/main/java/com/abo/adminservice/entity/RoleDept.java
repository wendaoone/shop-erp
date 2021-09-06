package com.abo.adminservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色与部门对应关系
 * </p>
 *
 * @author abo
 * @since 2021-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_dept")
@ApiModel(value="RoleDept对象", description="角色与部门对应关系")
public class RoleDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "fid", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    @ApiModelProperty(value = "系统id")
    private Long systemId;


}
