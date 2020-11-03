package ${pojoPackage};
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.ratel.common.core.entities.SuperEntity;

/**
 * ${company}
 * @ClassName: ${Table}
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: ${createTime}
 * @Description: ${Table}实体
 * @Version: 1.0
 */
@ApiModel(description = "${Table}实体", value = "${Table}")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("${TableName}")
public class ${Table} extends SuperEntity {
	private static final long serialVersionUID = 1L;

	<#list models as model>
	<#if model.name!='id' && model.name!='createTime' && model.name!='modifyTime'>
	@ApiModelProperty(value = "${model.desc!""}", required = false)
	<#if model.simpleType=='Date'>
	private Timestamp ${model.name};
	<#else>
	private ${model.simpleType} ${model.name};
	</#if>
	</#if>
	</#list>
}
