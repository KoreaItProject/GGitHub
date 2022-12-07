package com.ggit.vo;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
public class OverViewVo {
    String nick;
    String date;
    int count;
}
