package com.ratel.common.core.validator;

import com.ratel.common.core.exception.BizException;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * RatelCloud
 *
 * @ClassName: ValidatorUtils
 * @Package: com.ratel.common.core.validator
 * @Author: Eric
 * @Email: cheryleric0828@gmail.com
 * @Create: 18/09/20
 * @Description: hibernate-validator校验工具类
 * @Version: 1.0
 */
public class ValidatorUtils {

    private static final Validator validator;

    static {
        validator = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new MessageInterpolatorAdapter(new ResourceBundleMessageInterpolator()))
                .buildValidatorFactory().getValidator();
    }

     /**
      * @Author: Eric
      * @Date: 1:04 PM 18/09/20
      * @Description: 校验对象
      * @Param: object 待校验对象
      * @Param: groups 待校验的组
      * @Return: void
      * @Throws BizException 校验不通过，则报RRException异常
      */
    public static void validateEntity(Object object, Class<?>... groups) throws BizException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            ConstraintViolation<Object> constraint = (ConstraintViolation<Object>) constraintViolations.iterator().next();
            throw new BizException(constraint.getPropertyPath().iterator().next().getName() + " " + constraint.getMessage());
        }
    }
}
