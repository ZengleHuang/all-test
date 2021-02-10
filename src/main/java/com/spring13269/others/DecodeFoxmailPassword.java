package com.spring13269.others;

import java.util.Arrays;

/**
 * DecodeFoxmailPassword description
 *
 * @author zengle.huang@hand-china.com  2019/12/16
 * @version 1.0
 */
public class DecodeFoxmailPassword {
    /*char[] EncAlg(char[] src,boolean encrypt)
    {
        char[] data= {
                    0x7E, 0x46, 0x40, 0x37, 0x25, 0x6D, 0x24, 0x7E
            };
        int x=0;
        for(int i=0;i<data.length;i++)
        {
            x+=data[i];
        }
        x %=255;		//计算固定值

        char[] ret = Arrays.copyOfRange(src, 0, src.length/2);
        //char * ret=(char*)malloc(strlen(src)/2);

        memset(ret,0,strlen(src));
        char t0 [3]={0};
        memcpy(t0,src,2);
        int p1= IntFromHexStr(t0);

#ifdef DEBUG
        printf("p1= %d \n",p1);
#endif
        int v35 = p1 ^ x;
        int v36=0;
        int index=2;		//从0开始算，第二个字符开始解密
        int i=0;
        do{
            if(v36 >= sizeof(data))
                v36 = 1;
            else
                ++v36;
            memcpy(t0,src+index,2);
#ifdef DEBUG
            printf("dec = %02X \n",IntFromHexStr(t0));
#endif
            ret[i]= IntFromHexStr(t0) ^ data[v36-1];
#ifdef DEBUG
            printf("char =  %02X \n",ret[i]);
#endif
            int tmp=ret[i]&0xff;
            if(tmp > v35)
                tmp-=v35;
            else
                tmp=tmp+0xff-v35;
            ret[i]=(unsigned char)tmp;
            index+=2;
            v35=IntFromHexStr(t0);
            ++i;
        }while(strlen(src) > index);
#ifdef DEBUG
        printf("dec = %s\n",ret);
#endif
        return ret;
    }*/
}
