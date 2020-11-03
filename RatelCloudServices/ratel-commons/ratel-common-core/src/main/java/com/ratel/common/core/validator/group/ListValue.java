package com.ratel.common.core.validator.group;

import com.ratel.common.core.validator.ListValueConstraintValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * RatelCloud
 * @ClassName: ListValue
 * @Package: com.ratel.common.core.validator.group
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 30/9/20
 * @Description: ListValue验证器
 * @Version: 1.0
 */
@Documented
@Constraint(validatedBy = {ListValueConstraintValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface ListValue {
    String message() default "{com.ratel.common.core.validator.group.ListValue.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int[] vals() default {};
}

