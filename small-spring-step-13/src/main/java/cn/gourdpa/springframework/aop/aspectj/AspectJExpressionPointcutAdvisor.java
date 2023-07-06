package cn.gourdpa.springframework.aop.aspectj;

import cn.gourdpa.springframework.aop.Pointcut;
import cn.gourdpa.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
    private AspectJExpressionPointcut pointcut;
    private Advice advice;
    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }
    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
