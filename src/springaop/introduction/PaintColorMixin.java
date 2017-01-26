package springaop.introduction;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class PaintColorMixin extends DelegatingIntroductionInterceptor implements PaintColor {
    private String color = "Not Set";

    public String getColor() {
      return color;
    }
  
    public void setColor(String color) {
      this.color = color;
    }
}