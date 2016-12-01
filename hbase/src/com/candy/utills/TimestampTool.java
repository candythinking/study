package com.candy.utills;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TimestampTool {

    /**
     * 得到当前时间
     * @return
     */
    public static Timestamp crunttime() {
        return new Timestamp(System.currentTimeMillis());
    }
    //得到当天的小时数
    public static int getCruntHour(){
    	Calendar c = Calendar.getInstance();
    	return c.get(Calendar.HOUR_OF_DAY); 
    }
    
    public static String getCurrentDate() {
        Timestamp d = crunttime();
        return d.toString().substring(0, 10);
    }
    
    public static String getCurrentDateTime() {
        Timestamp d = crunttime();
        return d.toString().substring(0, 19);
    }

   
    public static String getStrDate(Timestamp t) {
        return t.toString().substring(0, 10);
    }

    public static String getStrDateTime(Timestamp t) {
        return t.toString().substring(0, 19);
    }
    
    public static String getStrIntervalDate(String days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -Integer.parseInt(days));
        String strBeforeDays = sdf.format(cal.getTime());
        return strBeforeDays;
    }

    
    public static Date parseDateTime(String dt) {
        Date jDt = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (dt.length() >= 19) {
                jDt = sdf.parse(dt);
            }else if(dt.length()>=16){
            	sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            	jDt = sdf.parse(dt);
            }else if(dt.length()>=10){
            	sdf = new SimpleDateFormat("yyyy-MM-dd");
            	jDt = sdf.parse(dt);
            }else{
            	jDt = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jDt;
    }

  
    public static String parseDateTime(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            s = f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public static String parseShortDateTime(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            s = f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
    public static String parseShortDateMMDD(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            s = f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public static String parseDateHm(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("HH:mm");
            s = f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String getOrderNo(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyMMddHHmmssSSS");
            s = f.format(date);
            s += ((int)(Math.random()*900)+100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
    public static String getLongDate(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
            s = f.format(date);
            s += ((int)(Math.random()*900)+100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    

    public static String parseShortDate(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yy.MM");
            s = f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    
    
    public static Date parseDate(String dt) {
        Date jDt = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (dt.length() >= 8) {
                jDt = sdf.parse(dt);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jDt;
    }

 
    public static String parseDate(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            s = f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    
    public static String getDateDirPath(String base) throws IOException {
    	Date date = new Date();
        SimpleDateFormat y = new SimpleDateFormat("yyyy");
        SimpleDateFormat m = new SimpleDateFormat("MM");
        SimpleDateFormat d = new SimpleDateFormat("dd");
        String stry = y.format(date);
        String strm = m.format(date);
        String strd = d.format(date);
        File fy = new File(base + "/"+ stry);
        File fm = new File(base + "/"+ stry+ "/"+ strm);
        File fd = new File(base + "/"+ stry+ "/"+ strm + "/"+ strd);
        if(!fy.exists()){
        	fy.mkdir();
        }
        if(!fm.exists()){
        	fm.mkdir();
        }
        if(!fd.exists()){
        	fd.mkdir();
        }
        
        return "/"+stry+"/"+strm+"/"+strd+"/";
    }
    
    public static String getLongDateFromShortDate(String dt) {
        String strDT = dt;
        try {
            if (strDT != null && strDT.length() <= 10) {
                strDT = dt.trim() + " 00:00:00";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return strDT;
    }

    public static String getShortDateToHHMM(String dt) {
        String jDt = dt;
        try {
            if (jDt != null && jDt.length() <= 10) {
                jDt = jDt + " 00:00";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            jDt = sdf.parse(jDt).toLocaleString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jDt;
    }

   
    public static String formatDateToHHMM(String dateStr) {
        String resultDate = null;
        try {
            if (dateStr.length() > 10) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
                Date date = sdf.parse(dateStr);
                resultDate = sdf.format(date);
            } else
                resultDate = dateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    public static Timestamp date(String str) {
        Timestamp tp = null;
        if (str.length() <= 10) {
            String[] string = str.trim().split("-");
            int one = Integer.parseInt(string[0]) - 1900;
            int two = Integer.parseInt(string[1]) - 1;
            int three = Integer.parseInt(string[2]);
            tp = new Timestamp(one, two, three, 0, 0, 0, 0);
        }
        return tp;
    }

  
    public static Timestamp datetime(String str) {
        Timestamp tp = null;
        if (str.length() >= 19) {
            String[] string = str.trim().split(" ");
            String[] date = string[0].split("-");
            String[] time = string[1].split(":");
            int date1 = Integer.parseInt(date[0]) - 1900;
            int date2 = Integer.parseInt(date[1]) - 1;
            int date3 = Integer.parseInt(date[2]);
            int time1 = Integer.parseInt(time[0]);
            int time2 = Integer.parseInt(time[1]);
            int time3 = Integer.parseInt(time[2]);
            tp = new Timestamp(date1, date2, date3, time1, time2, time3, 0);
        }else if (str.length() >= 16) {
            String[] string = str.trim().split(" ");
            String[] date = string[0].split("-");
            String[] time = string[1].split(":");
            int date1 = Integer.parseInt(date[0]) - 1900;
            int date2 = Integer.parseInt(date[1]) - 1;
            int date3 = Integer.parseInt(date[2]);
            int time1 = Integer.parseInt(time[0]);
            int time2 = Integer.parseInt(time[1]);
            tp = new Timestamp(date1, date2, date3, time1, time2, 0, 0);
        }else if (str.length() >= 10) {
            String[] date = str.split("-");
            int date1 = Integer.parseInt(date[0]) - 1900;
            int date2 = Integer.parseInt(date[1]) - 1;
            int date3 = Integer.parseInt(date[2]);
            tp = new Timestamp(date1, date2, date3, 0, 0, 0, 0);
        }
        return tp;
    }

    public static Timestamp datetimeHm(String str) {
        Timestamp tp = null;
        if (str.length() > 10) {
            String[] string = str.trim().split(" ");
            String[] date = string[0].split("-");
            String[] time = string[1].split(":");
            int date1 = Integer.parseInt(date[0]) - 1900;
            int date2 = Integer.parseInt(date[1]) - 1;
            int date3 = Integer.parseInt(date[2]);
            int time1 = Integer.parseInt(time[0]);
            int time2 = Integer.parseInt(time[1]);
            tp = new Timestamp(date1, date2, date3, time1, time2, 0, 0);
        }
        return tp;
    }

    private static int getMondayPlus() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); 
        return (dayOfWeek == 1) ? -6 : 2 - dayOfWeek;
    }


    public static Date getMondayOfWeek(int week) {
        int mondayPlus = getMondayPlus(); // 相距周一的天数差
        GregorianCalendar current = new GregorianCalendar();
        current.add(GregorianCalendar.DATE, mondayPlus + 7 * week);
        return current.getTime();
    }

   
    public static Date getDay(Date date, int day) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(GregorianCalendar.DATE, day);
        return c.getTime();
    }
    
    //比较两个时间差多少天
    public static long getDay(Date nowDate,Date lastDate){
    	long day = 0;
    	long time1 = nowDate.getTime();
    	long time2 = lastDate.getTime();
    	if(time1 > time2){
    		day = (time1 - time2)/(1000*60*60*24);
    	}else{
    		day = (time2 - time1)/(1000*60*60*24);
    	}
    	return day;
    }

   
    public static String[] getDaysOfWeek(int week) {
        String[] days = new String[8];
        Date monday = getMondayOfWeek(week);
        days[0] = getStrDate(new Timestamp(getDay(monday, -1).getTime()));
        days[1] = getStrDate(new Timestamp(monday.getTime()));
        Timestamp t;
        for (int i = 1; i < 7; i++) {
            t = new Timestamp(getDay(monday, i).getTime());
            days[1 + i] = getStrDate(t);
        }
        return days;
    }
    
   
    public static Date mccUTC2Date(long utc) {
        Date d = new Date();
        d.setTime(utc * 1000); 
        return d;
    }
    
    
    public static long mccDate2UTC(String str) {
    	Date d = parseDateTime(str);
        return (long)d.getTime()/(long)1000;
    }
	public static String getPreviousMonth(int month){
		Calendar   cal1   =   Calendar.getInstance();   
        cal1.setTime(new Date());   
        cal1.add(Calendar.MONTH,-month);               
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");   
        return formatter.format(cal1.getTime());
    }
	
	 public static boolean getDifferMinute(long utc, int minute) {
        Date newDate = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(newDate);
        c.add(GregorianCalendar.MINUTE, -minute);
        return (c.getTime().getTime() - utc*1000)>0?true:false;
    }

	 public static String compareDate(Date nowDate, Date compareD1, Date compareD2) {
		 if(null != compareD1 && null != compareD2){
			 if((nowDate.getTime() > compareD1.getTime()) && (nowDate.getTime() < compareD2.getTime())){
				return "1";
			 }
		 }
		 return "0";
	 }
	 
		public static Date getCurNextMin(Date tdate,int min){
			Calendar   cal1   =   Calendar.getInstance();   
	        cal1.setTime(tdate);   
	        cal1.add(Calendar.MINUTE,min);                
	        return cal1.getTime();
	    }
		//得到两个时间的中间时�?
		public static Date getCenterDate(Date beginDate,Date endDate){
			int min = (int) ((endDate.getTime()-beginDate.getTime())/(1000*2*60));
			return getCurNextMin(beginDate,min);
		}
		/**
		 * 某个时间点前后几天的所有时间(不含当天)
		 * 
		 * @return
		 */
		public static List<Date> getCountDay(int day,Date date) {
			List<Date> dateList = new ArrayList<Date>();
			if(day>=0){
				for(int i=1;i<=day;i++){
					dateList.add(getDay(date, i));
				}
			}else{
				for(int i=day;i>=0;i++){
					dateList.add(getDay(date, i));
				}
			}
			return dateList;
		}
		
		/**
		 * 某个时间点前后几天的所有时间字符串(含当天)
		 * 
		 * @return
		 */
		public static List<String> getCountStrDay(int day,Date date) {
			List<String> dateList = new ArrayList<String>();
			if(day>=0){
				for(int i=0;i<day;i++){
					dateList.add(parseDate(getDay(date, i)));
				}
			}else{
				for(int i=day;i>=0;i++){
					dateList.add(parseDate(getDay(date, i)));
				}
			}
			return dateList;
		}
		public static void main(String[] args) {
			//System.out.println(get);
			/*System.out.println(getStrIntervalDate("1"));*/
			/*String beginDate = "2015-05-30 12:30";
			String endDate = "2015-05-30 15:50";
			Date d = getCenterDate(parseDateTime(beginDate),parseDateTime(endDate));
			System.out.println(parseDateTime(d));
			System.out.println(parseDateTime(beginDate).getTime()-parseDateTime(endDate).getTime());*/
			/*String curr=getCurrentDate();
			System.out.println(curr);
			Date minDate = parseDateTime(curr);
			Date maxDate = getDay(minDate, 1);
			System.out.println((crunttime()>minDate));
			System.out.println(parseDateTime(minDate)+"------"+parseDateTime(maxDate));*/
		}
		
}
