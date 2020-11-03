package ${voPackage};
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

/**
 * ${company}
 * @ClassName: ${Table}VO
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: ${createTime}
 * @Description: ${Table} VO
 * @Version: 1.0
 */
@ApiModel(description = "${Table} VO", value = "${Table}")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ${Table}VO {
	private static final long serialVersionUID = 1L;

	<#list models as model>
	@ApiModelProperty(value = "${model.desc!""}", required = false)
	<#if model.simpleType=='Date'>
	private Timestamp ${model.name};
	<#else>
	private ${model.simpleType} ${model.name};
	</#if>
	</#list>
}

