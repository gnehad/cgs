package tlds;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CurrentDate extends TagSupport{
    @Override
    public int doStartTag() throws JspException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentDate = formatter.format(date);
        //Écrire dans la JSP
        JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
    try{  
     out.print(currentDate);//printing date and time using JspWriter  
    }catch(IOException e){
        System.out.println(e);
    }  
    return SKIP_BODY;
    }
}
