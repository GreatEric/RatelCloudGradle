package ${formPackage};
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import com.ratel.common.core.form.PageForm;
import com.ratel.common.core.enums.RelationEnum;
import com.ratel.common.core.mybatishelper.QueryField;
import ${pojoPackage}.${Table};
/**
 * ${company}
 * @ClassName: ${Table}QueryForm
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: ${createTime}
 * @Description: ${Table}查询表单
 * @Version: 1.0
 */
@ApiModel(description = "${Table}QueryForm", value = "${Table}QueryForm")
@Setter
@Getter
public class ${Table}QueryForm extends PageForm<${Table}> {
    <#list models as model>
    @QueryField(tableAlias ="${table?substring(0,3)!""}", column = "${model.column}", condition = RelationEnum.EQUAL)
    <#if model.simpleType=='Date'>
    private Timestamp ${model.name};
    <#else>
    private ${model.simpleType} ${model.name};
    </#if>
    </#list>
}
