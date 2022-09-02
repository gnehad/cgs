package tlds;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
public class CurrenteTime extends TagSupport{
    @Override
    public int doStartTag() throws JspException{
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String currentTime = formatter.format(date);
        //Écrire dans la JSP
        JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
    try{  
     out.print(currentTime);//printing date and time using JspWriter  
    }catch(IOException e){
        System.out.println(e);
    }  
    return SKIP_BODY;
    }
}
