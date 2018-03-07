package hadenmcafee.cidm4385.sp2018.wt.recipebook;

import java.util.Date;
import java.util.UUID;

public class Recipe {

    private UUID mId;
    private String mTitle;
    private String mIng1;
    private String mIng2;
    private String mIng3;
    private String mIng4;
    private String mIng5;
    private Date mDate;
    private boolean mSolved;

    public Recipe() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }
// 
    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    //ing 1
    public String getIng1(){
        return mIng1;
    }

    public void setIng1(String ing1){
        mIng1 = ing1.toString();
    }
    //ing 2
    public String getIng2(){
        return mIng2;
    }

    public void setIng2(String ing2){
        mIng2 = ing2.toString();
    }
    //ing 3
    public String getIng3(){
        return mIng3;
    }

    public void setIng3(String ing3){
        mIng3 = ing3.toString();
    }

    //ing 4
    public String getIng4(){
        return mIng4;
    }

    public void setIng4(String ing4){
        mIng4 = ing4.toString();
    }

    //ing 5
    public String getIng5(){
        return mIng5;
    }

    public void setIng5(String ing5){
        mIng5 = ing5.toString();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
