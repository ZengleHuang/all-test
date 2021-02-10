package com.spring13269.test.utils;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import sun.nio.ch.IOUtil;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * OKHTTPS
 *
 * @author : zengle.huang@hand-china.com 2020/11/10
 */
public class OKHTTPS {


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        //MediaType mediaType = MediaType.parse("multipart/form-data; boundary=------WebKitFormBoundary7MA4YWxkTrZu0gW1");
        /*RequestBody body = RequestBody.create(mediaType, "------WebKitFormBoundary7MA4YWxkTrZu0gW1\r\n" +
                "Content-Disposition: form-data; name=\"file\"; filename=\"H-印章.png\"\r\n" + *//* filename="E:\P开发项目\Z中粮糖业\H-印章.png"*//*
                //"Content-Type: image/png\r\n\r\n\r\n" +
                "Content-Type: image/png\r\n" +
                //"Content-Transfer-Encoding: binary\r\n\r\n\r\n" +
                "�PNG\r\n" +
                "1231231231231\r\n" +
                "------WebKitFormBoundary7MA4YWxkTrZu0gW1\r\n" +
                "Content-Disposition: form-data; name=\"appId\"\r\n\r\n" +
                "100000\r\n" +
                "------WebKitFormBoundary7MA4YWxkTrZu0gW1\r\n" +
                "Content-Disposition: form-data; name=\"bizContent\"\r\n\r\n" +
                "JTdCJTIyZG9jVHlwZSUyMiUzQSUyMi5wbmclMjIlMkMlMjJ1cGxvYWRUeXBlJTIyJTNBJTIyMiUyMiU3RA==\r\n" +
                "------WebKitFormBoundary7MA4YWxkTrZu0gW1\r\n" +
                "Content-Disposition: form-data; name=\"sign\"\r\n\r\n" +
                "RENFMTE0NjVFNzU5OTY3QkQxRUREMDU5NEU0RjI5OTY5OUYwMjU4NUFBQTUxRjBGNTQ2ODZGQzcyOUVBODE2OQ==\r\n" +
                "------WebKitFormBoundary7MA4YWxkTrZu0gW1\r\n" +
                "Content-Disposition: form-data; name=\"signType\"\r\n\r\n" +
                "SHA256\r\n" +
                "------WebKitFormBoundary7MA4YWxkTrZu0gW1\r\n" +
                "Content-Disposition: form-data; name=\"timestamp\"\r\n\r\n" +
                "2020-11-10 10:48:04\r\n" +
                "------WebKitFormBoundary7MA4YWxkTrZu0gW1--");*/

        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i");
        RequestBody body = RequestBody.create(mediaType, "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
                        "Content-Disposition: form-data; name=\"appId\"\r\n" +
                        "Content-Type: text/plain; charset=ISO-8859-1\r\n" +
                        "Content-Transfer-Encoding: 8bit\r\n" +
                        "\r\n" +
                        "100000\r\n" +
                        "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
                        "Content-Disposition: form-data; name=\"bizContent\"\r\n" +
                        "Content-Type: text/plain; charset=ISO-8859-1\r\n" +
                        "Content-Transfer-Encoding: 8bit\r\n" +
                        "\r\n" +
                        "JTdCJTIyZG9jVHlwZSUyMiUzQSUyMi5wbmclMjIlMkMlMjJ1cGxvYWRUeXBlJTIyJTNBJTIyMiUyMiU3RA==\r\n" +
                        "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
                        "Content-Disposition: form-data; name=\"sign\"\r\n" +
                        "Content-Type: text/plain; charset=ISO-8859-1\r\n" +
                        "Content-Transfer-Encoding: 8bit\r\n" +
                        "\r\n" +
                        "QzYxRDcxRDk0MUE2QUQyQ0JFNjE3REQyRUExMkQwRDI4QkVCQkQ3MDcwNzkxNDYyNEQ5OUI5MkQ5NkM1QUJDMg==\r\n" +
                        "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
                        "Content-Disposition: form-data; name=\"signType\"\r\n" +
                        "Content-Type: text/plain; charset=ISO-8859-1\r\n" +
                        "Content-Transfer-Encoding: 8bit\r\n" +
                        "\r\n" +
                        "SHA256\r\n" +
                        "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
                        "Content-Disposition: form-data; name=\"timestamp\"\r\n" +
                        "Content-Type: text/plain; charset=ISO-8859-1\r\n" +
                        "Content-Transfer-Encoding: 8bit\r\n" +
                        "\r\n" +
                        "2020-11-10 14:51:24\r\n" +
                        "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
                        "Content-Disposition: form-data; name=\"file\"; filename=\"H-印章.png\"\r\n" +
                        "Content-Type: text/plain\r\n" +
                        "Content-Transfer-Encoding: binary\r\n" +
                        "\r\n" +
                        "�PNG\r\n" +
                        "\u001A\r\n" +
                        "\u0000\u0000\u0000\r\n" +
                        "IHDR\u0000\u0000\u0001(\u0000\u0000\u0000l\b\u0006\u0000\u0000\u0000ٹ/�\u0000\u0000 \u0000IDATx���\u0007�uMU\u0006��Ŋ\u001D\u0005\u0005T��\u001D+`\u0003DQ\u0004\u0004D�H\bJ1�\u0012�\u001A1�H\u0000i\u0012�H\tJUQ\u0014\u0005{\u0001�`�XAA�w\u0011\u0014y����\u007F�}�>���;���&'���=g�ٳ�zW�5k���7�\f\f\f\f\u001C �y�\u000700000�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�k_�\u0001\\8���J��?)��������R���Kyի�����\\�'}R)��������)�\u001A�(�u�+�O��^����\u007F��x�:ש�y۷���\u007F��R���K�ֵ���.%��\u001FJ��\u007F���\u001F�Q�_�E)�������������|)?�\u0013����\u000F��R>��K��\u000F(����\\�\u007F���\u007F-�~�����:\u001F�oY���\u007F)��e)\u001F�����{]�!^\u000E�6A�˿�\uDA89\uDDD5�\u0017T\u0002!\u0004����n�3\u0014���*�[�E)��)����]�}���\u007FX�o�F)��[���ߔ�7Կ!�\u000F���p/\u007Fy)�xE)�}m}�\u0007}P)��M)7�����\t�}�ND�\u0014�������\u001DKy��)�]ߵ\u0012��q \u0018ʰ\u0004d�Z�\u0007I��wy�J&�ᚔ�F7*�\u001D�a�8���J��_.�YϪ��mަ����:���sp]�E1��\u0014��[e�\\<��U^<?����\\����\t�Pe\u0011Q�/��j��&����*��}n)\u007F���?�C��?��@\u0001��U�\u007F��R~�'Ky�3K�˿���\u0010�k^S�G|D)?��U�|?�͵xX��9U�\u0010ʫ_]��װ�(�@�\t3���_)�\u000F��������[%��~�JZ��_�|�ǖ�ɟ\\�Mnr�{l��\u007F�GK��\u07FE��\u0011\t�C|\u001F�a������\u001EΉE�\u0014��~��?��+�f^����{(�|H��>��K�����]�\u0018=�) y���\u007F�GJy�K��\u0081�c,��1Oݳ��\u0010�5O?Cs���\t�{\u0010\u0017\u0006\u000F�\u0015��\u001F��\u0016�K!\t\u0010�E������\u001E\u0004E���H�\u0005!CH\u0014��\u007F�\u0012\u0010B0\u001E\u0002FAYF�\u0006���ϯ�\u0012��G��\u0001y|�ח��'VR$��ŵy,Ƅ��\u0017ϒ��߷z�Rnz�e�\u0007i�\u000FJb����\u0005��a�\u0013ޛ{�Q�\u007F?��#\u001E�y�\u0013��\u0019W�\u001E�Q��\u001C�t)/�E�黄���1(�9�\\�s��}�7���\u0017U\u0003ǀ��/]U�Zx�R\u0015���7�$͠\\��}��&(\u000F����\u001F�a]�X��BQ��ݭz\u0007�w!\\rM^Jr\u0006-\bg�(��\u0005�0�S ��|d)OyJUl\u0016�wʃm����ϕ�'U%\u0000ʎ\b��s@�ƈ\u0014>����Kr=��Ԗ���W��Y�\u0006����\u001F��\u0007\u007F��2#�zAB\u001B����_�W�C�r^\b\u0018�^�z����\r\n" +
                        "��=\b�=\u001F��8<��<��|���y\u0012�/�S��y/��\u0018\b���\t���\u00162!\u0006��r�\u0001e\u0015Z���5$�\r\n" +
                        "�X.�G���b\u0006����,�ַ��G9_�ª�<5\u0002̢\"�\u0007>p�}�q\b\u007F����_��^��s�[ܢ��������Ԅ�撢�\b�{\u0016:��^�P�ܲX�\f}Vޥ�\u001F@Д\u0018q�s���\\�V��c��:d\u0018�9�\u0015!\u0012� \u0002�b�<\u001F�f��9X\u00022Oڂ��gƇ\u0011=Q�6A�P���C�9P���R�t���F\u0018s9��h�\u0002�I8���_�3<\u0001�\u001C�{�\f���@�\b\u001E��\u0012� \u0010��\u0004*k��p�<#\u001E��#C���~�p>�s�v���>��kx8EP��xA���?�\u0012��PX\u001E@��\u001E��\u0015��g~f)w�{)7�Y���\r\n" +
                        "\uF41F���W2\u001E�o\u0005�@�H�����< �2�<�5\u001E�\u001A��~�\u0017��@\u0019TD\u001ECp\"8}��\u0000\tbV�v\u0001!\t��p�\u001A\u001E-��ȿ�\u0002�p-�<�s�S����_��$�\u0011\u0006�o��vV�����+\f���\u0012\u0002N!Yn�!��(��~��\u0011�\\�\u001EA ����{Eƒ��#�\u00152�I��\u000F�<VKB�g�\u000B�\u001A\u0007OIB\u0018���\u001B����������1 �\t�R\b�͑\u0005�0�lI~�\f\u0012\u0012���{�2�_^�E!yP��3硛��Ŏ#��\u0011�\u0010�p#\u001E\u0002\u001DE����! \u0004��L%�c�[���\u000B�X\"���k%ٙ�\u0018�\u001A�\u0018ל�~�w�Ў@��9\t\u000B�9��\u0019�u\u0017V\u0019�>+W�O\t��Gv\tYYv�q��{�\u001C\u0016���\b����Z�_��xxjm\u000E��s�E�\u000F\"��$�_��+�\u001Ez�t��Ɓ8y��ν\u0018�ߟ�\u0012�q(����\u0010�\u001F\\��s0\u001F��=x��\b�H���}���3�M�SN�gj���\u001Fz\b�\u0001�GP\\r�\u0011���O�+\u001A\u0014\u0383ꗵY\u00169\u001EB6\u0015�]��ճb-\u0003$������o)w�c\u0015\u0004�;\u000F \tq�C����@�)\u0001�IXG���xQB?�����\u000B�/�c�yP\u0014P\b���Fx\u000E�)��{��G欰D�g}�U\u000BV�5%07H�<\u0000�q=\u0004h����o�HH�������0�\u0007't��~���E\u000E����ZK\u0019.�C`��\u0016�J���~7�y��\u0010�\u001C�y@��<�\u001B�o�ys\f\f�\"k��.\u0013���^2�����\u0530\t\u0010\u000B������\u000BY�{�Jk�\u0003V��gP\f$(�����\u001E:�e\r\n" +
                        "�w!��m���\fxeHJ��~\u0006A|�\u0017U���߭�E)\u070F��S�����3$,LJ5=R�\u001D\u0011p�\u001D\u000F����=#H�\r\n" +
                        "�G�\u0004?���x[\b��w��&��-���5��\u00131~d�X\u0018\u000E/��5\u0018���t��!\u001F�s��\u0014p��/ֹ�w?+9p/B1^�Y�7\u0011\u001D��gG�ͽ�1/s\t�\u0014�&wx)`n���#�f8�8���=0&J5N\b�EP�Ҽ��o\u0010Q\r\n" +
                        "�X<\u0002$\u0014�;J��~�x��.%�C4BKQ�B*��\u0018��D\u0014[�����}7n�E��U\u0019��\r\n" +
                        "�X�����TRg�+��>p]�\u0015�QB���\b�|��ݗ�\u0001\u0004f��\r\n" +
                        "�,,EX�\"�Jh�\u0012�\u0012�恂xy/��ji�E����__�dx]��G%\u001F�Lxe�)]<\u0018cA���A�\r\n" +
                        "a���\u0098x�H�\\��~\t�w^�G<Esʀ%��9d�\u0019d�.O�܍�K\u000E��Ǹ�\u0011��̜P�\t���<\u001C���N�p<0\u0016�ã8,��p�eL\u00128���N)@N,V�\"��d��R$Dŋ�=�a\uD93B\uDE5CJ�{(0e�����\u0010B8J�\u0010\\���.�CX��=Q�}��-����JfL�\u0011!�}��Wd�R.�\u001B�2\u007Fȉ�v\u001F\u0012�\b��\u0018\u000B�f��z\u001D�\u000FY�/���~Q�}#��\u07B7*��\\\u0018̛�a\u000E\u0011�{\u00122\r\n" +
                        "Wo\u007F�\u001A\u0016n]�\u0004r�\u0014\u0015J�Ƕ�{\u000E�\u0019#\u000F`N�����\u0010���e&����E��TB7�Ɇ��U�\u001F�3\u00072��'��\"(`��v��\u0004\u0004�аH\b�\u0012�P(\u0017A��\r\n" +
                        "?#�\u0007<�ZU[2\b��L����'�kȫ,!��xu���\u0015+;���\u007F���B\uDA81\uDCA0�<�\fξ�\u001E��{�|wo\u0014�\u0018�w��C�^�QBV��R \u001Cߑ����\u0006J�\u0018�\u001C�d��u\b�\u0017Dɑ��\u0012�-�8䳄���\r\n" +
                        "�pE�j�b\u0002#�s����fE\u0016\u0018/%(`y�g�s�\u001EH�at����ݮ\u0012M\u001B��m�VN��^��9��컛��\u0011�YA�\b\u0013W\u001Aѥ:7�\u0005\u0010V�\u001F\u001E\r\n" +
                        "�=�-\u0005��'C�CP�U.\u0007��\u007F��+����u\u0001�Rִ �95�A�\u0016\u000E��0�������DĻ��L�x2\u0014V����W�g�2\u007F\r\n" +
                        "\b����+K�����+���>�u��sH9+��6E�m�3^{K�K2�����19��\u0013\u0014�ai\t\u000B\u000B+�Cx\b\u0019\u0005�7\u0011�\u001Be\"P��\r\n" +
                        "\u07B3�N�5\u0015\r\n" +
                        "�aD�M���@��߅��&A��uw-\r\n" +
                        "���\u0012|\u000F�H�R�\u0005�\r\n" +
                        "�Rv�`��jpx����lێ\u0011sy�t,�1�7�R=��\t�\u0014-Zy|ԣ��˺�V-YP�H ��99�\u0011�<#\b��*�\u0014NPxy�l\u0000f��.\u0015�<\u0001n�U�]�\u0001YMZ\u0003�\u000E%��\u0004Rr+a�������\bod�Pp\u000E\u0012�}����[O<�%�S���Z�֒��Kʺ�Զ\u001E�(�J���?�\r\n" +
                        "���|�mK�F�\u00147��,�%[B<s�mF�����@�S+�\u0003�p�\u001E\u0014$�Iٔ\"P�4_�U���&a-ߔB�]@t��\u0006\b�\u0012xQ\fcJI���6O�����p�x�,\u001F���Ǘ\r\n" +
                        "�<1d'?Ү\b�xR8�\u001C%�y�B\u000B�5Fd!�4na��+�2#.!Zzf�(s\r\n" +
                        "̱{46��<����-�\f�0��-�\u0007�\u0016)#�+��-�\b���C\u000E�Q4������\t��\u007F�-��\u001A�x\bjic%�\u0000�L-�\u0012 ��(��(�2\u00122�\",�\u001E�GAB\f>��\u0014xJ�\u0012�A�/J隬�v#_�u5�ӆdَ�\u0016\b�����CЗB��0� x(\r\n" +
                        ".\u001F�2��]\b��H�\r\n" +
                        "P8��^�l\u000E(�9G\u008AEyO\u0014��(^��!����\\_}>���z��*IYɛKT�o��<My$�u���\u0012\\g�z��M�\u0007\b\u001E�x.<�)��\u0002��g��X`��+���hK\r\n" +
                        "Y��I���څ��#!(BdՈ�1�\u0014L�YP�\u001E\u001E�Z\u0012B#�\"\f��r�܅�\r\n" +
                        "YQ*��\t%E���F`�ӚJ����m\r\n" +
                        "(/!u\u000FrQ���$�2Gr<,��T��j�R�����Q*$��(\u0014Ϩ��$ѝ��(��[u��V\u0014��p\u0013���\u001E�\u000F�W��*o�QHLQ�.X\u0011���CI�\u001EQK{\u0000)��XS\u000E�\u0006�[�o�{\u0012�2P[��\u0005H��~�ʋ\u0005�^\r\n" +
                        "\u001Ao��K\u001E�T\b��l�ϢɥH�\u001F\t\u000E��\b\u000FA��hnW8�@M����\u001CE�|��.p��X��\u0019�cPh�L�,�S\u0006\u0004��,�\"B���\r\n" +
                        "�/֔b��Ϩ�����\r\n" +
                        "&�Ș�Z$�Z�=$��I\u000F���1�ݰ�\u001A�=�\u0011u�>\u0005����+b��ü�\u001E\u0002\u0016��\u0006�\u0013e�}�\u001E\u0014ų5\b�������,�Ήk!Д� �)O(^�\u001C�o�b'\u0007�\u0016�]Y@�7�-?\bȓ��\u000B\u0015=��J�\u000BI)i�;[���\u0006��� }�)�\\�\u000F\u0002�7R�;^\u0000b��%d��2�;��w\u0004D\u0011yS<\u0005\u0095|\r\n" +
                        "\"a�y\r\n" +
                        "�\u000FR��=^��5m@�G[����\u0000b�ğ��) P\u0002l�C\b�R'\u007F��\u001A� ^^_rQ�v\u0001� @�� \u0010��\r\n" +
                        "����\u001D\t�(/O\u0000!�\u0002\u001EI�W��sSE�=�\u0017��\u001E\r\n" +
                        "�z&�<پ/U�\b�7P��7֭�7�\u0016\u000F�%\u000E��Fs�q\u001FoM\u001E�\\���{�yrƈY\u0015\u001D\u0004�f\u001C>AQ\u0010�/\u0002�|Gvt'\u0007�BH�\u000F%CDə��<+\u008BpX�\u0010T�\u001DA�N`y\u001C\t\u0010PJ�E�(�\\1�q�.�C�s�\u0003�I�yp��\u0004�D�9�=�V�(\"\"m;I&w� �U�������e��pm�e�y7HS-\u0018�p]s���\u001CDi��9�X\u0013\u0016%�E��Y�~�\u001C��^�3U~�:���ٺ7�\u001C�[���\u001C/;��\u001E��9H)�)��9���s4~U���-�\u0012��\t*���k��d�\u001AO!�\f����Y�Ҫ��*>'o�\u0006i\u0002F@\t�pAh9e�[\u0018���d7�9�\u0018/+?���0\u0002�~ݐ\u0004�֭\u001A�B�\u001C\u0011#g���LY��k�����SB��[��\u0010�\u0012\u0002��\u0019��\u0001\u0014Y\u0011[{8�g)4��K�1��W'��ȴI�A��w\tA�u��k�l���x��lM��j��px\td��y�S�\u052B)\u000E��� ��,n�3���xV\u0004^�&g@�)�ph�wă��laٵJG1\b$\u000B>�z� 2�S�\u0015� P��`\r\n" +
                        "u\b��6\u0019����{3Nޟ\u001C�ҹ\u007F=(�y�řK{᐀�\u001B\u0018�D�\u0005\u0005J�u�l\t\bqW1\"��f^�%\u007F'��zY\bJ��y�k\t�h�\u0001x�K\u0006%\u0007`�E:��c���q\u001C\u0004\u0005S�Q\u0002��x�K-��QP,�g�\u001B�Y:҉� ��:R�\u0014\u00106��[V�b��E�AR��X��x|��xSG�\u0018u9��ϫ!�Zd?]��}��R6IY\u0015��\u05C8�xP�<֜�\u0015�n�Ki#�[�B���f\u007F����]<�>�J\u001EikH��\"�-�5\u000E�hW)@�\u0011{\r\n" +
                        "���\u0004�%�]���}\u000E�8\u0012\u001C\u000FA-�ҷy\u000F?{�\r\n" +
                        "��X�G\u0011�e\u001F^[Ԙ�\u0003��.\u007F��Sby���ζy�\u0014x\u001E<�v�����\r\n" +
                        "� |\u007F���Dz���9$��yr��!�\u001C��s\u0001�\u0016��r\u000Fx��G�\u000FA�HB�_Y4W\u0016.(d_\u0004�6/kz÷p��\u0010��\u0013�\u001B��<XK >wQ�����ɕI/H\u0019H��\u0017�\t�4\b*mz{\u0010��CΡ�@�,�J\u0001����,��\r\n" +
                        "��\bxB�e\u0014Z\"-^\u0006�#�}(�\u0015��x\u0001��]9ԠU6މR��������=s�9ĳM����/�c�g΄RH+�2\r\n" +
                        "�����du�%�ܯ�,�ʮ�Z�R\"�Jj���O��҉\u00169l��\u001C�\u0006ih�o�\trІ�n\t����ﹶy�;\u0018�,���\u001CJ�3��sFB��\u0011]j�rd8\r\n" +
                        "����\u0007�0�\u0013���K�(&Š�9��R=���{�\u0011�'�8�\u0011N�)眩5��P�S������\\��n\t�W�>-my\u001D��FRzWQ�/����,\u001Dku\u0016�/��6<@(���RD���x.H\by�\u0017��\b挷�\u001E�=A��fh^�T��v\u001C��n\u0004\r\n" +
                        "e\u0015���K�l\u0013�!L�����\u0006)J��\u000E1^=��\t���<���Sk๐�̅��@�ԥ\u001A�r���)F��q\u001A\u0004%\u0014�e\t\u0004���c<}�x4�\u0007E@Y%�E|\u0007\u000Fg\r\n" +
                        ")\u0015 ��}l�\u000EE���UL\u0002C�\u0014[�A}�w���\u0016�[�rIXy��\"(\r\n" +
                        "�3h\t����[�j���x�\u000BbF�\b\u0014�\u0011oJm\u0018/D\u001E�\u0019����ە�Wk���W�h�<\u000FU�k�����3Z�=�Ryl�~�W\u001FV\u001A\u0003���d>��;��\"�\u0015�Q[�v�3s��C��\uDB80\uDC5B�;�\u0013�\u0017p\u001A\u0004���;Z�\u001C�-t!��)\u000F��씏�ކ�y�9E��BC��}�S�.E��BKV�\u0015p֘R+����\uE7A0�'\r\n" +
                        "s�\r\n" +
                        "�s\u0004y���%IoD�\u0003\u001C�z7�^j��\u0010\u0015/K�\u0013�tȁU�t���\u0002!\u0014\u0005�\r\n" +
                        "i�a���:\fu�^҇i-r,��Mmn�#\u0018�+�*֧�<g�\u001E\u00183�<���&T�F��/\u0011��ڟɘ�+�٪��(�(ɲE\u0017��5\u001B�\u000F\u0014�APb�]]-\u0003$�\u0003\u0001B�B�g�q\u000F�Ǣ.&\u0004E�x\u0010�ڑ��\u000E{!�U0ᒜ�\u001CN\u000E�$8�\u001E���;(��#�)aD\u0010BD�h��E��!ݖ<���-%)�]B��≘\u0007�,<���B�\u0002�\t9Q��#���:�i\u000E�$�\f�,�#_!��[k\b�M��?��\u001Ey[����\u001F�軘fN��<\u0004����ޚ;�a�\u001B�{Ȃ\\\u0018r��3\u0000S�2\u0007� G�xy��P�L\u001E�07u\u001A\u0004Œ�]1!\u0010��\u000B���=��\u0005E�1�\u0011��\bN!�\tW\r\n" +
                        "4)�\u0017�ț��!(B�k�+�#��\u0007�\bB��l��~P���\u0019��M\u001D.���nûL?�5+Iy\u000Fe�L>g�y��ϵ���m!�l��_C�kH�gR�\u0015�<Yٔk\u0014~1<H�'Y�ؕ��\u001E[� 2���\r\n" +
                        "j\u0016\u0017x��\u00119��D^Hl\r\n" +
                        "x�<���\"�d��p\u001A\u00045�l�lW�\bH����w�FhY�5�B\u0004G�w�̺�(�]��>�P\u000F|�����>Q���\u0014L^�}�\u000F$!T\u07B2�d�|�1���\u0005���.\u001Bbs�$�����ĲtnL�{����}\r\n" +
                        "5���\u0013�U�;��m;Zf\u007F C%���\"���\u0011�G��\u0001���\u0014�e�\u0019.2��\u0010I\u0016\u0005b0�\t\u0016�\u0019�gd�9�%m��/��.\t�<�1Z��A\r\n" +
                        "�:0 \u001AJ�*�j��pD�e����U1����\u001B\u00047mu�{e)=��%��%�@��[��PP�F�\u0005f\u007Fb�������2����9������wG>r�\r\n" +
                        "\"Ez�\r\n" +
                        "9H!���͐��4\u0004�=�ޟ�6���/�0~���a�'r�:2���N���M_*+�*�uZ@�i�\u0017��R\r\n" +
                        "@lȒ�\u007F�;�68G��%(ލ���_]��\u0003�e�\t�$m�W&\f�K\\��\u0004�\u0017��\u0015�kmi%K1��\u001A߂)��<(�����[�T o�Vك\u0002!\u0011ߕӄ�l�M�\u000Bȗr�(�\u0011BBF�9��rs�u�U /�46_�7�\r\n" +
                        "\uE4EF37V\u000FyQ��w�7Jm�9Y���lH�\\�ؐBjڲy:{CyC���W%(��-T\bȵ����\"\u007F�&�\u0004�<SM�cOZ��1C��h��̣{����g^ N��<�~凰QDy��v�0M���w�M���%ѹT%�ծ�@\u0011\"�k+{\t��V�s �m\u0002\u0016r��p\u0001a.)���\r\n" +
                        "ܷ\\GO��\u0019�ȹ\u0011zV\u001F9����\u0017\u0012e��Q�\u001E�`L<<ח���S+yI�#�\u052Ei<�C-�\"�\u0010�f�\\�sj;[��{d�xj�ں��s�X:\u0018�wfOd�o^\u0018�\u0010��Y����8\u0001�\u0006Ayh}op�E���O�r\u00052�%$�~\u058C0�:Y�!�Y�i�!\u009C#Ճ4�\u0003�a<��R��\u0011���{\r\n" +
                        "\u0014�x��o\u007F�\r\n" +
                        "k�kL\u0019\u007F\u0012��\u001F���طHY(X߬��H�x\u001D9&]>\u0005i�\u0005�R��)��=�=�AtB\u0015�������n�5\u0007K-N�U�]�'\u0007[����Z/�u��D�<p\u001A\u0004E���=(�\u0012�\u0016�^-C�\u0016kh\u001F�\u0004b��jTr�z�^L���>\u001BX)�0�'�5I�[ON\u0001A�ͥ�\u0015���3uHg\u0012�-(\u0004/(=\u0601r��^\b\u001F�����<ɑ!R�-�\u0003��mp�j#�-�c�'O�JU�I\u001F\u001A���\u0013�\"�c��E�Ԑ�0����?�\u037F[q\u001A\u0004�6)k�JrJK�$mS�4�3\u0012\u0002�\r\n" +
                        "P�\u0007=�&�s ����\u001Ew���<om���PsK��lk��\u000E���\r\n" +
                        "A�\u0003��ܻ�@\t#�#2\u0012N�\u0013[_�p\t�������\u001F_���ԙ\u0016�U���\u0007�jw����J!��F\u000F\u0004��]{���\u0004�AP[\r\n" +
                        "5!�\u000B\u0010\u001B�셴��Dm\uF178>�KH�>�rU�7����9\r\n" +
                        "\u0006QPb�c�ޔ@N!mo�i�F��xz�z�\u0003bB&s�S��UE{\u0003A\u0018�j�N个�J��x���}�'�\u0003�I������1\u0018s��YeEb��m�J\u001A\u0011�W\bd�e�*/Ƴ�<\u0010�02�M��7��Bcd��� \u0007�\u000E��\u0012N����\u0007�\u0003%��_��5��bB`�\t�!�!��\u001A�9����,��X(��\b9lcHr3�`�?Y�a\u00131Y�\u0012�I���c�1څ�ss�\u0004\u0005r\u000F\u0014���5!&d��#$��i=7���\u0011P���9s���=�l�2�z���ds��B�H�},\u001D��\u0016��\u001A'ǁ�\u0001���\u0017�3\u0000ɷ�.�z��.[��N�W,}���$C����\u007F������ �\u0014��\u0001%��_��5o�d&�`�[d%�^3�!i\u001C \u0013�\u0018rj��g��\b�T�'!%��r�$�\u001C���}\b��Pޅ�柚7�G0�q�%���~�,\b%��@��IZ���ƥ_��3\u0000m�w�\"\u001DP�>��\u001F�\u0000\u0000\u0011�IDATC^�r\t\u001E�- �%\u001C=��jr�^����'�sj�~YV\u000Es�\u0004YZS\u001A��:�VZ!���a��d��Q �\u0010�� ;�!i\u0005�5\u00162w�2�\u0003�i\u0010\u0014�ڲ\u007F\u000B\u0010J��B�U7�V��xB\u0016֬�z\u0014Ћ�\u0011�)� l}X�d3eP�\u0602��z\u001F\u0001a�Ҵ��u-\u0010�\u0012�\u001C�$����G�I^Q\uA7C4\u007F\u0016\u0012ZBt���3\u0001�Bp/zQ%w��)���z�g^\t�7�G?z[}��\r\n" +
                        "�\u0010\u0014o�,y�\u0018'[I<��EH*�Sy\t\u0005�\uD9F0\uDE02I���kW�\u0003�ɩ>}!p����ģU\u0013������\u0017�9���G��|!~���uMsk,VX��\u001E�'�� (\u000F��\u001Ft��+Y���\u0002e���\u0016������Z�A\u0016�ns�l� (�p�8U\u001A�&�\\��x!����'d��\u0006\u0001�\u0004��@yH�T *=�\u0012��|C���R�in\u001F���\u000F�LI�Yڛ b����\u001A\t~��\\a/o��y�rg_�啨va�O��3Zzb!\"�l>\u0010Q�\u0000�U�cN3\r\n" +
                        "�\u001A7�צG//Du\u0011;\u0012.\u0003N�����@\u0010���\u001D\u001Er�\u0014J1ջ�\u0002����W̭�C��\u001Fڲ�g�!�x\u0011S���k�Se�\u001A�\t'\t?h��y��+����h�셛�@+��ZBѩ$|\u000EFuo9.�G�i�w���*%�)�^��g)L�5�\u00172d\u000E͋�!WƯ��z�^��w$�[���Aj��$yr�d�l2j�\u0006\u000F}h%@��S��,��r�����`��y��.#N���*ɭ��\u0017(�\u0017�\u0010\u0010��\u001E�݂జ�\tZ��%�.�.��.�g%jn#�E$B͋$�q\u0010�\u0010T��{B�o1\u000Fm�\t� k��hZ���\u0010^����\u001A\u0018'�A?��l������$�\u001E���\u0012\r\n" +
                        "���g�b��f\u001E��q��#?��$\u001DV��R��b\u001FQ�h�,p\t���ԃ�Z���#\u000E�N��<�~�A��\u0011\u001CV;\u0002D�X+���\u0013�\u0001q*g�\u000B�L^\"U�i��_����r�H���F\u0014� �����H\tw)\\z���r\u000Fڃ�\u0004%� �S\u0004�$�PqKMھ�tr]<\u0005\u001E�>J�]\u0005\fX*�sp�ܦ�\u0014�z�\b\r\n" +
                        "���=�O�\u0012T@�̭봲�w<}U��w�O��R��\b\t[-r跕��G�� ��C\u0013�\uF4B4VŢX@ y\u0012�\u0015\u0005&D���N�d��|\r\n" +
                        "\u0001gmm\f�=�\u001E�@\u0012���V�e*L8+r��7}�\u0015\u001E\u0010\"jk�\u0010$ҵm�7�DP\b\u0006��]�����������r}I�\u000BQ=�V1��s�˜7��,�q�\u001Cx�\u0012��\"�o$��\u00039Sj�%�E\u00009\u0015'`0����g=�-#\u000B\u0010SD�\u000BBx[�N!�'=�\u0012��:�\u0012�� �\u001C}ރ0��G\u000B��\u001F�z�t\u001DHX��P.�nD����o�\u0013eJ'M��Ը�\u0003)S@�\u0011�^�\u0011dN��'Q�k�3 �\u0012�\u000E�D�[Z(g<�^�5K�m�i�PR�]I_�ׇx9i\u0017�#�^��\u001E�9\u0005���\u001A㝫`��>t\u001D����\u0018���<\u000Fr�)24_rXSy;\u001D9�Ȭ��\u001A�e�P�x�'\u0007G�� (���5#�,\u0007�ow�PVI�t�g�T\u0012�\u001E�%\\���! �I?�֟�Y������|�E�Ax$�yo�\u0003im�\f&�kC\u0015\u0002�6\u001A�1�t7�\u0017��\r\n" +
                        "j����\u001A\r\n" +
                        "\u001E%��I\u000E\u0014�\r\n" +
                        "�\u0017V �6$\u0011�L�W\r\n" +
                        "\u0016�*��ߘ=۩\u000E�k��.䄔\u001Cy\u000F�yB�Sߋ�U�/��J��k�\u0017��J#�\u000F�H�\b�˦�\u0007�?��g�\u001D�Q��]�\r\n" +
                        "\t_��n\u0006���\u001D\u0019N��\b��\u001C��Ab}�p\b\u0014AA$\u0012��L\u001E�ʇ\u0007�\u0015&\u0004�C�\u0010\f�\"\u0014��\"++G� �I�K����h&B/t�������<>^C�,G\r\n" +
                        "Ʒv�(E�Q�s];)Hz\u0010�\u0014�\t�t\b��\u001DkR6+��r�\u0016&�\u0017��G1�!�TS�S!iB�\u0016�\u001F�߹\u0005\u0005�9�!��{\u000Exh����\u0017\u0014\u0012�ڻ\u00042�\u0002Rc�����\u0016��e9��\u0005\u0006\u0004�\u001C�\\\u000B��#���>\u0018`s����褗� (�P��Z�G0<x^�\u0007�� \u0016^����L�My*�\u001C\u000F�\u0003OGG �s�\u0010�XZ\u0002�|�\r\n" +
                        "��\u001F�B������\bo�l\u0010\u0001�^8�\u0017�Rۏ\u001E\u0004\r\n" +
                        "9#ȥ%�v�.߇���r��\u000E(^���V X�Y�)�+���n�qyV�N�%=�|���uxb\u0014l��;+A�\u0011D*wؒQ\u0016\u001F��L�\u0013^�U�]�\\x�)�u\u001D2b��1�m�F،��=�_[�r �U�\u001C�\u0000�/�e\\�a�.T�\u000B\u1F4EhU�4\b�CQ���<�U ��~/�I��U(\r\n" +
                        "��P��[�\u07BBT�#*\u000FU��*�.\u000F\u0002)q��0���Ƃ��|�\u001A1P\u0000-`\u0010\u0014aD���*om[k��\u001Ea%%�\u001B�M�R��̅q�������)�%�Vs�\u0010Q��9����攎�\bw\u00108�rM���n\u007F�+*�*�\u0019��ǝ�@�ȑ��z\"I�\u0007I^{���g5p��B�7?�\u001B$���|Ov/�Ͷvo�Gc,dT�����Ş\u001C&�{\u0019_s��{�\u0005\u0003�K�U\u0001-��'��\f8\r\n" +
                        "�\u0002J&�V\u0013�\u0004<�x\u0001,F������T��u��,M�\u0006yP\u0012y�9�HO}j=\r\n" +
                        "h.\u001F@\u0010\u0010\u0002��\u0010�\u0005�Y��\u0010N� Oc+A��=\u0019\u007F��S��\u0012n��*�cI�\u0012��h*a���ӷ�\r\n" +
                        "l��\u0012ȫ���dկ�g�sB^[�3�\u0002\r\n" +
                        "�\u001Cw�^�搓6/�r=r1\u0007�\u0018�\" �O��-D}2��&\u0016f1l���'�����3GB�)\u000F�\u001A(�d\b,\b�&�\u001E2q�p:\u0004���R����'?��S�{>%\u0003�CR����e�J}�N\u000F��M\u0011�DI\\R�>q��&89]&uR\u0014���>�9J�+��í9P~�\t�?��\u001FRBВ�~�PPO+�&�K@�SM���,�=�MJ;\u0016�c��o��V�\tam��l��7��T�?ƈ!\u0012��\u0003Ϟ��Ζ�ҸOF�˾�z���BR��&���V���D\\}(ǫ�\u000BDbd%�U�1\u000F��!�����O��\u00079\r\n" +
                        "�5��J�r��:\u0012�\u000EA�\u0002��K,�4�Ԟ*\uF736�A�\u0015!+\u001E\u000E�\u0000)��\f\r\n" +
                        "o5O�]X�b\t\u0019�as�,%gKD�T�\u0006>âf\u001F\u001C��}\u0014cn�z��\u0012�\u0011XB�&��!\r\n" +
                        "-(\u001AO����z�n�\u000Fs���x\u0003�g����lk\u001E�͉���|��E�F�XΆ浥\u0001=�����\u0012�@��0Ӽe�\u0010���1I�\u000B\u0015�B���z��{ṑ���\u0017xF�|m���������p�\u0004�l\u0010\r\n" +
                        "r�z�*�k���\u0006�%Gp,v\u0014450ix\u0007Vo$/\u0011U�}cI�\b��E����?9)^�\\\u0011�dI��\u0007�Udd�{��k�����6��JZ;\u0017�c7u���H\u000B����(�\\;�t2@\u001C<\u009C��\u0006<\f\tkū���:��q�ӝ*A� \u0005�D���w�?�c�\\{�ʉ���s���^�o�˗`������{d�ƽm�J��8]�J\u001D�\u0004�\u0013�PsK��ݵ\u0010��@K.2�U�0U$(��b�%µ� ��O�A6\u001Ag�����^5��\u0003O\u00029J���yx��w]Q�R�8�$G\f꿦H���B�6���\u0002}//D(�� ����(��[Qݥt�\u001C���\u0018H��=��\f�d��8ײ��yƈ\u001F�\b�\u0019���/\u0006��#��ɹ�]��Y�1�hmN\r\n" +
                        "��o��@�����}��\u0017�\u001EQϨ�%(\u000F�V��?��\r\n" +
                        "[�u\u0007��\u0014/����qW� �>\u0012ت\u007F���j��\r\n" +
                        "#�OR}���۔\u0015%�����m�\u0006^ȹl=��\u0014qd�k�\u001C@�e$,�˵\b\tS\u0013֟D�DN�[���u�\u0018�\u001Ers�������>o�B8g\u0011�\u0017�+�����\u0001\u000F�s�5r�!�'�I��C!��=\blK�f̼7d��Է���x�VUy|���J\f�4\t�\u0002\u0010\u000E�2\t�]=�[XM��[�O�\\h��K���6aO8\b��|�U���1猹%Pt.�\u007F�^�x�\u001Aoo���\u00070U~�e�\u001E<#�o�s\u0000&�\u0000a��\f������E1O���w������hMH�씑X \u0011B#7!\u000F�� !�f�xFk�Y\b)=\u001B\u001E5/U�IK\u000E�t\u001C/t�\u0001��e�o˞9�KVS���$��]�0��\\)��j�\u000E\u0000�CPIp��\\x\u000F*�\u052EA��R\u0017D���r��bux1�n��F�t�����*\fd%�'�� �l��g��R�|�8)\bO��\"�f>�\u0011\u0018\u0017�CR\b\"+^�)�{Bd[�:K\u0007-\u0000��g�U��\u0019$�D��k\t}�m\u0017��\u0015\u0002{I��0'k6��0Y\u001E�\u0016�2f/2J�ytY��;E��B�y��\u0004�MP�1\u0011B�$1�kR\u0017��s\u0010��䄌E�1q�Y��<0��H�R\u000E�\u000F��`���L-���!��\u0004B�m\u0018\bPn\u0004ɞ��F�iil=��Z�L\u0011!���\bws\f��᩸����9��bT�l�h��x-s\u0004���F���J\u001E撇�#6WBߥBҵ�|%í\fN�2�\u000B�\u0013o(Gxm\u0005c��U�p�|��u�\u0001�섏� �\u0004C��E�C�\u0006�\u0010�f[V��$�ڶ����� ��\u0003�B\"Q�H�x\u001Bs��,�.�\u0002©�@XEa�*�s9�) Z�I��#B��\u001D�;�bs\u0016�3�����BP���t\u001C\u0014��Xa�\u0011\bO�\u001C���s�C\u0016Z�|x��\u0013/rK:�,�9a�>[�Z��\u001Eg��\u0001��\b���)qۭzH��v�#��0��&L6\u000B\u0013Ҵ�Hõ�\r\n" +
                        "�\u0012\\_�%�\u0003b��%�\u0017���g�(/�\u001E�ྐ\u0013Eu�)\u0002h\r\n" +
                        "��x�G\u001Ee�\u0006V�Exv���oI��<6%\u0016�T\u0011��\"��#s���\u0014_\u000B��UC�!��۹\b\u001C\u000FA��<\u000F�L�%D%��1۩�EB�&���GLȨ\r\n" +
                        "=�:\u0001\\\u0004�ϸ�{�!_�\u000490\u001EԖ럗��G����jS��9 GD��̸lI\r\n" +
                        "��<a�k�L(�\u0002V�aZ��ǥ\u0005\u0000s���7(�C�\u0017�\u0007�|�\r\n" +
                        "A6�JJ������\u0013\"s���l=��8\u000E�\"��R��B\u0001�\u001C\u000B*�a\u0015��VL\b\u001Fa&�\u0004��\u001E~��\u000F��Ø)X�IH�g\u001BI�Y�\u0019�R��\u0001�c�ݼ&��U�^�x@B(�����<\u001A$��qߞ+\u0002�G����ay�\u001CfI�yGK0�H�R�B���U3\u000B\u0015�O\r\n" +
                        "�\"P2�0��q��./\u0005���7\u001E��\u001C+!��I\u0000[\u0019\"��#�1���\u0014='\u0001#�c�����/�9\u0004��SX��d���z\u000F]$$�yyrQ�$\r\n" +
                        "����\u001B�z�)$Q�V,�y�R�Go�x�Y|\t���]\u0018x�\u000B0'�� �S\u0006�P\u001E-��E$�\u0007\u0006�\u0014��\u000E\u0001<\b9\u0017�#��30p)0\bj``�`q<͉\u0007\u0006\u0006�v\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p��\u007F`:��!j\u0004�\u0000\u0000\u0000\u0000IEND�B`�\r\n" +
                        "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i--\r\n"
                );
//        MediaType mediaType = MediaType.parse("multipart/form-data; boundary=ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i");
//        RequestBody body = RequestBody.create(mediaType, "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
//                "Content-Disposition: form-data; name=\"appId\"\r\n" +
//                "Content-Type: text/plain; charset=UTF-8\r\n" +
//                "Content-Transfer-Encoding: 8bit\r\n" +
//                "\r\n" +
//                "100000\r\n" +
//                "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
//                "Content-Disposition: form-data; name=\"bizContent\"\r\n" +
//                "Content-Type: text/plain; charset=UTF-8\r\n" +
//                "Content-Transfer-Encoding: 8bit\r\n" +
//                "\r\n" +
//                "JTdCJTIyZG9jVHlwZSUyMiUzQSUyMi5wbmclMjIlMkMlMjJ1cGxvYWRUeXBlJTIyJTNBJTIyMiUyMiU3RA==\r\n" +
//                "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
//                "Content-Disposition: form-data; name=\"sign\"\r\n" +
//                "Content-Type: text/plain; charset=UTF-8\r\n" +
//                "Content-Transfer-Encoding: 8bit\r\n" +
//                "\r\n" +
//                "QzYxRDcxRDk0MUE2QUQyQ0JFNjE3REQyRUExMkQwRDI4QkVCQkQ3MDcwNzkxNDYyNEQ5OUI5MkQ5NkM1QUJDMg==\r\n" +
//                "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
//                "Content-Disposition: form-data; name=\"signType\"\r\n" +
//                "Content-Type: text/plain; charset=UTF-8\r\n" +
//                "Content-Transfer-Encoding: 8bit\r\n" +
//                "\r\n" +
//                "SHA256\r\n" +
//                "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
//                "Content-Disposition: form-data; name=\"timestamp\"\r\n" +
//                "Content-Type: text/plain; charset=UTF-8\r\n" +
//                "Content-Transfer-Encoding: 8bit\r\n" +
//                "\r\n" +
//                "2020-11-10 14:51:24\r\n" +
//                "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i\r\n" +
//                "Content-Disposition: form-data; name=\"file\"; filename=\"H-印章.png\"\r\n" +
//                "Content-Type: text/plain\r\n" +
//                "Content-Transfer-Encoding: binary\r\n" +
//                "\r\n" +
//                "�PNG\r\n" +
//                "\u001A\r\n" +
//                "\u0000\u0000\u0000\r\n" +
//                "IHDR\u0000\u0000\u0001(\u0000\u0000\u0000l\b\u0006\u0000\u0000\u0000ٹ/�\u0000\u0000 \u0000IDATx���\u0007�uMU\u0006��Ŋ\u001D\u0005\u0005T��\u001D+`\u0003DQ\u0004\u0004D�H\bJ1�\u0012�\u001A1�H\u0000i\u0012�H\tJUQ\u0014\u0005{\u0001�`�XAA�w\u0011\u0014y����\u007F�}�>���;���&'���=g�ٳ�zW�5k���7�\f\f\f\f\u001C �y�\u000700000�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�AP\u0003\u0003\u0003\u0007�k_�\u0001\\8���J��?)��������R���Kyի�����\\�'}R)��������)�\u001A�(�u�+�O��^����\u007F��x�:ש�y۷���\u007F��R���K�ֵ���.%��\u001FJ��\u007F���\u001F�Q�_�E)�������������|)?�\u0013����\u000F��R>��K��\u000F(����\\�\u007F���\u007F-�~�����:\u001F�oY���\u007F)��e)\u001F�����{]�!^\u000E�6A�˿�\uDA89\uDDD5�\u0017T\u0002!\u0004����n�3\u0014���*�[�E)��)����]�}���\u007FX�o�F)��[���ߔ�7Կ!�\u000F���p/\u007Fy)�xE)�}m}�\u0007}P)��M)7�����\t�}�ND�\u0014�������\u001DKy��)�]ߵ\u0012��q \u0018ʰ\u0004d�Z�\u0007I��wy�J&�ᚔ�F7*�\u001D�a�8���J��_.�YϪ��mަ����:���sp]�E1��\u0014��[e�\\<��U^<?����\\����\t�Pe\u0011Q�/��j��&����*��}n)\u007F���?�C��?��@\u0001��U�\u007F��R~�'Ky�3K�˿���\u0010�k^S�G|D)?��U�|?�͵xX��9U�\u0010ʫ_]��װ�(�@�\t3���_)�\u000F��������[%��~�JZ��_�|�ǖ�ɟ\\�Mnr�{l��\u007F�GK��\u07FE��\u0011\t�C|\u001F�a������\u001EΉE�\u0014��~��?��+�f^����{(�|H��>��K�����]�\u0018=�) y���\u007F�GJy�K��\u0081�c,��1Oݳ��\u0010�5O?Cs���\t�{\u0010\u0017\u0006\u000F�\u0015��\u001F��\u0016�K!\t\u0010�E������\u001E\u0004E���H�\u0005!CH\u0014��\u007F�\u0012\u0010B0\u001E\u0002FAYF�\u0006���ϯ�\u0012��G��\u0001y|�ח��'VR$��ŵy,Ƅ��\u0017ϒ��߷z�Rnz�e�\u0007i�\u000FJb����\u0005��a�\u0013ޛ{�Q�\u007F?��#\u001E�y�\u0013��\u0019W�\u001E�Q��\u001C�t)/�E�黄���1(�9�\\�s��}�7���\u0017U\u0003ǀ��/]U�Zx�R\u0015���7�$͠\\��}��&(\u000F����\u001F�a]�X��BQ��ݭz\u0007�w!\\rM^Jr\u0006-\bg�(��\u0005�0�S ��|d)OyJUl\u0016�wʃm����ϕ�'U%\u0000ʎ\b��s@�ƈ\u0014>����Kr=��Ԗ���W��Y�\u0006����\u001F��\u0007\u007F��2#�zAB\u001B����_�W�C�r^\b\u0018�^�z����\r\n" +
//                "��=\b�=\u001F��8<��<��|���y\u0012�/�S��y/��\u0018\b���\t���\u00162!\u0006��r�\u0001e\u0015Z���5$�\r\n" +
//                "�X.�G���b\u0006����,�ַ��G9_�ª�<5\u0002̢\"�\u0007>p�}�q\b\u007F����_��^��s�[ܢ��������Ԅ�撢�\b�{\u0016:��^�P�ܲX�\f}Vޥ�\u001F@Д\u0018q�s���\\�V��c��:d\u0018�9�\u0015!\u0012� \u0002�b�<\u001F�f��9X\u00022Oڂ��gƇ\u0011=Q�6A�P���C�9P���R�t���F\u0018s9��h�\u0002�I8���_�3<\u0001�\u001C�{�\f���@�\b\u001E��\u0012� \u0010��\u0004*k��p�<#\u001E��#C���~�p>�s�v���>��kx8EP��xA���?�\u0012��PX\u001E@��\u001E��\u0015��g~f)w�{)7�Y���\r\n" +
//                "\uF41F���W2\u001E�o\u0005�@�H�����< �2�<�5\u001E�\u001A��~�\u0017��@\u0019TD\u001ECp\"8}��\u0000\tbV�v\u0001!\t��p�\u001A\u001E-��ȿ�\u0002�p-�<�s�S����_��$�\u0011\u0006�o��vV�����+\f���\u0012\u0002N!Yn�!��(��~��\u0011�\\�\u001EA ����{Eƒ��#�\u00152�I��\u000F�<VKB�g�\u000B�\u001A\u0007OIB\u0018���\u001B����������1 �\t�R\b�͑\u0005�0�lI~�\f\u0012\u0012���{�2�_^�E!yP��3硛��Ŏ#��\u0011�\u0010�p#\u001E\u0002\u001DE����! \u0004��L%�c�[���\u000B�X\"���k%ٙ�\u0018�\u001A�\u0018ל�~�w�Ў@��9\t\u000B�9��\u0019�u\u0017V\u0019�>+W�O\t��Gv\tYYv�q��{�\u001C\u0016���\b����Z�_��xxjm\u000E��s�E�\u000F\"��$�_��+�\u001Ez�t��Ɓ8y��ν\u0018�ߟ�\u0012�q(����\u0010�\u001F\\��s0\u001F��=x��\b�H���}���3�M�SN�gj���\u001Fz\b�\u0001�GP\\r�\u0011���O�+\u001A\u0014\u0383ꗵY\u00169\u001EB6\u0015�]��ճb-\u0003$������o)w�c\u0015\u0004�;\u000F \tq�C����@�)\u0001�IXG���xQB?�����\u000B�/�c�yP\u0014P\b���Fx\u000E�)��{��G欰D�g}�U\u000BV�5%07H�<\u0000�q=\u0004h����o�HH�������0�\u0007't��~���E\u000E����ZK\u0019.�C`��\u0016�J���~7�y��\u0010�\u001C�y@��<�\u001B�o�ys\f\f�\"k��.\u0013���^2�����\u0530\t\u0010\u000B������\u000BY�{�Jk�\u0003V��gP\f$(�����\u001E:�e\r\n" +
//                "�w!��m���\fxeHJ��~\u0006A|�\u0017U���߭�E)\u070F��S�����3$,LJ5=R�\u001D\u0011p�\u001D\u000F����=#H�\r\n" +
//                "�G�\u0004?���x[\b��w��&��-���5��\u00131~d�X\u0018\u000E/��5\u0018���t��!\u001F�s��\u0014p��/ֹ�w?+9p/B1^�Y�7\u0011\u001D��gG�ͽ�1/s\t�\u0014�&wx)`n���#�f8�8���=0&J5N\b�EP�Ҽ��o\u0010Q\r\n" +
//                "�X<\u0002$\u0014�;J��~�x��.%�C4BKQ�B*��\u0018��D\u0014[�����}7n�E��U\u0019��\r\n" +
//                "�X�����TRg�+��>p]�\u0015�QB���\b�|��ݗ�\u0001\u0004f��\r\n" +
//                "�,,EX�\"�Jh�\u0012�\u0012�恂xy/��ji�E����__�dx]��G%\u001F�Lxe�)]<\u0018cA���A�\r\n" +
//                "a���\u0098x�H�\\��~\t�w^�G<Esʀ%��9d�\u0019d�.O�܍�K\u000E��Ǹ�\u0011��̜P�\t���<\u001C���N�p<0\u0016�ã8,��p�eL\u00128���N)@N,V�\"��d��R$Dŋ�=�a\uD93B\uDE5CJ�{(0e�����\u0010B8J�\u0010\\���.�CX��=Q�}��-����JfL�\u0011!�}��Wd�R.�\u001B�2\u007Fȉ�v\u001F\u0012�\b��\u0018\u000B�f��z\u001D�\u000FY�/���~Q�}#��\u07B7*��\\\u0018̛�a\u000E\u0011�{\u00122\r\n" +
//                "Wo\u007F�\u001A\u0016n]�\u0004r�\u0014\u0015J�Ƕ�{\u000E�\u0019#\u000F`N�����\u0010���e&����E��TB7�Ɇ��U�\u001F�3\u00072��'��\"(`��v��\u0004\u0004�аH\b�\u0012�P(\u0017A��\r\n" +
//                "?#�\u0007<�ZU[2\b��L����'�kȫ,!��xu���\u0015+;���\u007F���B\uDA81\uDCA0�<�\fξ�\u001E��{�|wo\u0014�\u0018�w��C�^�QBV��R \u001Cߑ����\u0006J�\u0018�\u001C�d��u\b�\u0017Dɑ��\u0012�-�8䳄���\r\n" +
//                "�pE�j�b\u0002#�s����fE\u0016\u0018/%(`y�g�s�\u001EH�at����ݮ\u0012M\u001B��m�VN��^��9��컛��\u0011�YA�\b\u0013W\u001Aѥ:7�\u0005\u0010V�\u001F\u001E\r\n" +
//                "�=�-\u0005��'C�CP�U.\u0007��\u007F��+����u\u0001�Rִ �95�A�\u0016\u000E��0�������DĻ��L�x2\u0014V����W�g�2\u007F\r\n" +
//                "\b����+K�����+���>�u��sH9+��6E�m�3^{K�K2�����19��\u0013\u0014�ai\t\u000B\u000B+�Cx\b\u0019\u0005�7\u0011�\u001Be\"P��\r\n" +
//                "\u07B3�N�5\u0015\r\n" +
//                "�aD�M���@��߅��&A��uw-\r\n" +
//                "���\u0012|\u000F�H�R�\u0005�\r\n" +
//                "�Rv�`��jpx����lێ\u0011sy�t,�1�7�R=��\t�\u0014-Zy|ԣ��˺�V-YP�H ��99�\u0011�<#\b��*�\u0014NPxy�l\u0000f��.\u0015�<\u0001n�U�]�\u0001YMZ\u0003�\u000E%��\u0004Rr+a�������\bod�Pp\u000E\u0012�}����[O<�%�S���Z�֒��Kʺ�Զ\u001E�(�J���?�\r\n" +
//                "���|�mK�F�\u00147��,�%[B<s�mF�����@�S+�\u0003�p�\u001E\u0014$�Iٔ\"P�4_�U���&a-ߔB�]@t��\u0006\b�\u0012xQ\fcJI���6O�����p�x�,\u001F���Ǘ\r\n" +
//                "�<1d'?Ү\b�xR8�\u001C%�y�B\u000B�5Fd!�4na��+�2#.!Zzf�(s\r\n" +
//                "̱{46��<����-�\f�0��-�\u0007�\u0016)#�+��-�\b���C\u000E�Q4������\t��\u007F�-��\u001A�x\bjic%�\u0000�L-�\u0012 ��(��(�2\u00122�\",�\u001E�GAB\f>��\u0014xJ�\u0012�A�/J隬�v#_�u5�ӆdَ�\u0016\b�����CЗB��0� x(\r\n" +
//                ".\u001F�2��]\b��H�\r\n" +
//                "P8��^�l\u000E(�9G\u008AEyO\u0014��(^��!����\\_}>���z��*IYɛKT�o��<My$�u���\u0012\\g�z��M�\u0007\b\u001E�x.<�)��\u0002��g��X`��+���hK\r\n" +
//                "Y��I���څ��#!(BdՈ�1�\u0014L�YP�\u001E\u001E�Z\u0012B#�\"\f��r�܅�\r\n" +
//                "YQ*��\t%E���F`�ӚJ����m\r\n" +
//                "(/!u\u000FrQ���$�2Gr<,��T��j�R�����Q*$��(\u0014Ϩ��$ѝ��(��[u��V\u0014��p\u0013���\u001E�\u000F�W��*o�QHLQ�.X\u0011���CI�\u001EQK{\u0000)��XS\u000E�\u0006�[�o�{\u0012�2P[��\u0005H��~�ʋ\u0005�^\r\n" +
//                "\u001Ao��K\u001E�T\b��l�ϢɥH�\u001F\t\u000E��\b\u000FA��hnW8�@M����\u001CE�|��.p��X��\u0019�cPh�L�,�S\u0006\u0004��,�\"B���\r\n" +
//                "�/֔b��Ϩ�����\r\n" +
//                "&�Ș�Z$�Z�=$��I\u000F���1�ݰ�\u001A�=�\u0011u�>\u0005����+b��ü�\u001E\u0002\u0016��\u0006�\u0013e�}�\u001E\u0014ų5\b�������,�Ήk!Д� �)O(^�\u001C�o�b'\u0007�\u0016�]Y@�7�-?\bȓ��\u000B\u0015=��J�\u000BI)i�;[���\u0006��� }�)�\\�\u000F\u0002�7R�;^\u0000b��%d��2�;��w\u0004D\u0011yS<\u0005\u0095|\r\n" +
//                "\"a�y\r\n" +
//                "�\u000FR��=^��5m@�G[����\u0000b�ğ��) P\u0002l�C\b�R'\u007F��\u001A� ^^_rQ�v\u0001� @�� \u0010��\r\n" +
//                "����\u001D\t�(/O\u0000!�\u0002\u001EI�W��sSE�=�\u0017��\u001E\r\n" +
//                "�z&�<پ/U�\b�7P��7֭�7�\u0016\u000F�%\u000E��Fs�q\u001FoM\u001E�\\���{�yrƈY\u0015\u001D\u0004�f\u001C>AQ\u0010�/\u0002�|Gvt'\u0007�BH�\u000F%CDə��<+\u008BpX�\u0010T�\u001DA�N`y\u001C\t\u0010PJ�E�(�\\1�q�.�C�s�\u0003�I�yp��\u0004�D�9�=�V�(\"\"m;I&w� �U�������e��pm�e�y7HS-\u0018�p]s���\u001CDi��9�X\u0013\u0016%�E��Y�~�\u001C��^�3U~�:���ٺ7�\u001C�[���\u001C/;��\u001E��9H)�)��9���s4~U���-�\u0012��\t*���k��d�\u001AO!�\f����Y�Ҫ��*>'o�\u0006i\u0002F@\t�pAh9e�[\u0018���d7�9�\u0018/+?���0\u0002�~ݐ\u0004�֭\u001A�B�\u001C\u0011#g���LY��k�����SB��[��\u0010�\u0012\u0002��\u0019��\u0001\u0014Y\u0011[{8�g)4��K�1��W'��ȴI�A��w\tA�u��k�l���x��lM��j��px\td��y�S�\u052B)\u000E��� ��,n�3���xV\u0004^�&g@�)�ph�wă��laٵJG1\b$\u000B>�z� 2�S�\u0015� P��`\r\n" +
//                "u\b��6\u0019����{3Nޟ\u001C�ҹ\u007F=(�y�řK{᐀�\u001B\u0018�D�\u0005\u0005J�u�l\t\bqW1\"��f^�%\u007F'��zY\bJ��y�k\t�h�\u0001x�K\u0006%\u0007`�E:��c���q\u001C\u0004\u0005S�Q\u0002��x�K-��QP,�g�\u001B�Y:҉� ��:R�\u0014\u00106��[V�b��E�AR��X��x|��xSG�\u0018u9��ϫ!�Zd?]��}��R6IY\u0015��\u05C8�xP�<֜�\u0015�n�Ki#�[�B���f\u007F����]<�>�J\u001EikH��\"�-�5\u000E�hW)@�\u0011{\r\n" +
//                "���\u0004�%�]���}\u000E�8\u0012\u001C\u000FA-�ҷy\u000F?{�\r\n" +
//                "��X�G\u0011�e\u001F^[Ԙ�\u0003��.\u007F��Sby���ζy�\u0014x\u001E<�v�����\r\n" +
//                "� |\u007F���Dz���9$��yr��!�\u001C��s\u0001�\u0016��r\u000Fx��G�\u000FA�HB�_Y4W\u0016.(d_\u0004�6/kz÷p��\u0010��\u0013�\u001B��<XK >wQ�����ɕI/H\u0019H��\u0017�\t�4\b*mz{\u0010��CΡ�@�,�J\u0001����,��\r\n" +
//                "��\bxB�e\u0014Z\"-^\u0006�#�}(�\u0015��x\u0001��]9ԠU6މR��������=s�9ĳM����/�c�g΄RH+�2\r\n" +
//                "�����du�%�ܯ�,�ʮ�Z�R\"�Jj���O��҉\u00169l��\u001C�\u0006ih�o�\trІ�n\t����ﹶy�;\u0018�,���\u001CJ�3��sFB��\u0011]j�rd8\r\n" +
//                "����\u0007�0�\u0013���K�(&Š�9��R=���{�\u0011�'�8�\u0011N�)眩5��P�S������\\��n\t�W�>-my\u001D��FRzWQ�/����,\u001Dku\u0016�/��6<@(���RD���x.H\by�\u0017��\b挷�\u001E�=A��fh^�T��v\u001C��n\u0004\r\n" +
//                "e\u0015���K�l\u0013�!L�����\u0006)J��\u000E1^=��\t���<���Sk๐�̅��@�ԥ\u001A�r���)F��q\u001A\u0004%\u0014�e\t\u0004���c<}�x4�\u0007E@Y%�E|\u0007\u000Fg\r\n" +
//                ")\u0015 ��}l�\u000EE���UL\u0002C�\u0014[�A}�w���\u0016�[�rIXy��\"(\r\n" +
//                "�3h\t����[�j���x�\u000BbF�\b\u0014�\u0011oJm\u0018/D\u001E�\u0019����ە�Wk���W�h�<\u000FU�k�����3Z�=�Ryl�~�W\u001FV\u001A\u0003���d>��;��\"�\u0015�Q[�v�3s��C��\uDB80\uDC5B�;�\u0013�\u0017p\u001A\u0004���;Z�\u001C�-t!��)\u000F��씏�ކ�y�9E��BC��}�S�.E��BKV�\u0015p֘R+����\uE7A0�'\r\n" +
//                "s�\r\n" +
//                "�s\u0004y���%IoD�\u0003\u001C�z7�^j��\u0010\u0015/K�\u0013�tȁU�t���\u0002!\u0014\u0005�\r\n" +
//                "i�a���:\fu�^҇i-r,��Mmn�#\u0018�+�*֧�<g�\u001E\u00183�<���&T�F��/\u0011��ڟɘ�+�٪��(�(ɲE\u0017��5\u001B�\u000F\u0014�APb�]]-\u0003$�\u0003\u0001B�B�g�q\u000F�Ǣ.&\u0004E�x\u0010�ڑ��\u000E{!�U0ᒜ�\u001CN\u000E�$8�\u001E���;(��#�)aD\u0010BD�h��E��!ݖ<���-%)�]B��≘\u0007�,<���B�\u0002�\t9Q��#���:�i\u000E�$�\f�,�#_!��[k\b�M��?��\u001Ey[����\u001F�軘fN��<\u0004����ޚ;�a�\u001B�{Ȃ\\\u0018r��3\u0000S�2\u0007� G�xy��P�L\u001E�07u\u001A\u0004Œ�]1!\u0010��\u000B���=��\u0005E�1�\u0011��\bN!�\tW\r\n" +
//                "4)�\u0017�ț��!(B�k�+�#��\u0007�\bB��l��~P���\u0019��M\u001D.���nûL?�5+Iy\u000Fe�L>g�y��ϵ���m!�l��_C�kH�gR�\u0015�<Yٔk\u0014~1<H�'Y�ؕ��\u001E[� 2���\r\n" +
//                "j\u0016\u0017x��\u00119��D^Hl\r\n" +
//                "x�<���\"�d��p\u001A\u00045�l�lW�\bH����w�FhY�5�B\u0004G�w�̺�(�]��>�P\u000F|�����>Q���\u0014L^�}�\u000F$!T\u07B2�d�|�1���\u0005���.\u001Bbs�$�����ĲtnL�{����}\r\n" +
//                "5���\u0013�U�;��m;Zf\u007F C%���\"���\u0011�G��\u0001���\u0014�e�\u0019.2��\u0010I\u0016\u0005b0�\t\u0016�\u0019�gd�9�%m��/��.\t�<�1Z��A\r\n" +
//                "�:0 \u001AJ�*�j��pD�e����U1����\u001B\u00047mu�{e)=��%��%�@��[��PP�F�\u0005f\u007Fb�������2����9������wG>r�\r\n" +
//                "\"Ez�\r\n" +
//                "9H!���͐��4\u0004�=�ޟ�6���/�0~���a�'r�:2���N���M_*+�*�uZ@�i�\u0017��R\r\n" +
//                "@lȒ�\u007F�;�68G��%(ލ���_]��\u0003�e�\t�$m�W&\f�K\\��\u0004�\u0017��\u0015�kmi%K1��\u001A߂)��<(�����[�T o�Vك\u0002!\u0011ߕӄ�l�M�\u000Bȗr�(�\u0011BBF�9��rs�u�U /�46_�7�\r\n" +
//                "\uE4EF37V\u000FyQ��w�7Jm�9Y���lH�\\�ؐBjڲy:{CyC���W%(��-T\bȵ����\"\u007F�&�\u0004�<SM�cOZ��1C��h��̣{����g^ N��<�~凰QDy��v�0M���w�M���%ѹT%�ծ�@\u0011\"�k+{\t��V�s �m\u0002\u0016r��p\u0001a.)���\r\n" +
//                "ܷ\\GO��\u0019�ȹ\u0011zV\u001F9����\u0017\u0012e��Q�\u001E�`L<<ח���S+yI�#�\u052Ei<�C-�\"�\u0010�f�\\�sj;[��{d�xj�ں��s�X:\u0018�wfOd�o^\u0018�\u0010��Y����8\u0001�\u0006Ayh}op�E���O�r\u00052�%$�~\u058C0�:Y�!�Y�i�!\u009C#Ճ4�\u0003�a<��R��\u0011���{\r\n" +
//                "\u0014�x��o\u007F�\r\n" +
//                "k�kL\u0019\u007F\u0012��\u001F���طHY(X߬��H�x\u001D9&]>\u0005i�\u0005�R��)��=�=�AtB\u0015�������n�5\u0007K-N�U�]�'\u0007[����Z/�u��D�<p\u001A\u0004E���=(�\u0012�\u0016�^-C�\u0016kh\u001F�\u0004b��jTr�z�^L���>\u001BX)�0�'�5I�[ON\u0001A�ͥ�\u0015���3uHg\u0012�-(\u0004/(=\u0601r��^\b\u001F�����<ɑ!R�-�\u0003��mp�j#�-�c�'O�JU�I\u001F\u001A���\u0013�\"�c��E�Ԑ�0����?�\u037F[q\u001A\u0004�6)k�JrJK�$mS�4�3\u0012\u0002�\r\n" +
//                "P�\u0007=�&�s ����\u001Ew���<om���PsK��lk��\u000E���\r\n" +
//                "A�\u0003��ܻ�@\t#�#2\u0012N�\u0013[_�p\t�������\u001F_���ԙ\u0016�U���\u0007�jw����J!��F\u000F\u0004��]{���\u0004�AP[\r\n" +
//                "5!�\u000B\u0010\u001B�셴��Dm\uF178>�KH�>�rU�7����9\r\n" +
//                "\u0006QPb�c�ޔ@N!mo�i�F��xz�z�\u0003bB&s�S��UE{\u0003A\u0018�j�N个�J��x���}�'�\u0003�I������1\u0018s��YeEb��m�J\u001A\u0011�W\bd�e�*/Ƴ�<\u0010�02�M��7��Bcd��� \u0007�\u000E��\u0012N����\u0007�\u0003%��_��5��bB`�\t�!�!��\u001A�9����,��X(��\b9lcHr3�`�?Y�a\u00131Y�\u0012�I���c�1څ�ss�\u0004\u0005r\u000F\u0014���5!&d��#$��i=7���\u0011P���9s���=�l�2�z���ds��B�H�},\u001D��\u0016��\u001A'ǁ�\u0001���\u0017�3\u0000ɷ�.�z��.[��N�W,}���$C����\u007F������ �\u0014��\u0001%��_��5o�d&�`�[d%�^3�!i\u001C \u0013�\u0018rj��g��\b�T�'!%��r�$�\u001C���}\b��Pޅ�柚7�G0�q�%���~�,\b%��@��IZ���ƥ_��3\u0000m�w�\"\u001DP�>��\u001F�\u0000\u0000\u0011�IDATC^�r\t\u001E�- �%\u001C=��jr�^����'�sj�~YV\u000Es�\u0004YZS\u001A��:�VZ!���a��d��Q �\u0010�� ;�!i\u0005�5\u00162w�2�\u0003�i\u0010\u0014�ڲ\u007F\u000B\u0010J��B�U7�V��xB\u0016֬�z\u0014Ћ�\u0011�)� l}X�d3eP�\u0602��z\u001F\u0001a�Ҵ��u-\u0010�\u0012�\u001C�$����G�I^Q\uA7C4\u007F\u0016\u0012ZBt���3\u0001�Bp/zQ%w��)���z�g^\t�7�G?z[}��\r\n" +
//                "�\u0010\u0014o�,y�\u0018'[I<��EH*�Sy\t\u0005�\uD9F0\uDE02I���kW�\u0003�ɩ>}!p����ģU\u0013������\u0017�9���G��|!~���uMsk,VX��\u001E�'�� (\u000F��\u001Ft��+Y���\u0002e���\u0016������Z�A\u0016�ns�l� (�p�8U\u001A�&�\\��x!����'d��\u0006\u0001�\u0004��@yH�T *=�\u0012��|C���R�in\u001F���\u000F�LI�Yڛ b����\u001A\t~��\\a/o��y�rg_�啨va�O��3Zzb!\"�l>\u0010Q�\u0000�U�cN3\r\n" +
//                "�\u001A7�צG//Du\u0011;\u0012.\u0003N�����@\u0010���\u001D\u001Er�\u0014J1ջ�\u0002����W̭�C��\u001Fڲ�g�!�x\u0011S���k�Se�\u001A�\t'\t?h��y��+����h�셛�@+��ZBѩ$|\u000EFuo9.�G�i�w���*%�)�^��g)L�5�\u00172d\u000E͋�!WƯ��z�^��w$�[���Aj��$yr�d�l2j�\u0006\u000F}h%@��S��,��r�����`��y��.#N���*ɭ��\u0017(�\u0017�\u0010\u0010��\u001E�݂జ�\tZ��%�.�.��.�g%jn#�E$B͋$�q\u0010�\u0010T��{B�o1\u000Fm�\t� k��hZ���\u0010^����\u001A\u0018'�A?��l������$�\u001E���\u0012\r\n" +
//                "���g�b��f\u001E��q��#?��$\u001DV��R��b\u001FQ�h�,p\t���ԃ�Z���#\u000E�N��<�~�A��\u0011\u001CV;\u0002D�X+���\u0013�\u0001q*g�\u000B�L^\"U�i��_����r�H���F\u0014� �����H\tw)\\z���r\u000Fڃ�\u0004%� �S\u0004�$�PqKMھ�tr]<\u0005\u001E�>J�]\u0005\fX*�sp�ܦ�\u0014�z�\b\r\n" +
//                "���=�O�\u0012T@�̭봲�w<}U��w�O��R��\b\t[-r跕��G�� ��C\u0013�\uF4B4VŢX@ y\u0012�\u0015\u0005&D���N�d��|\r\n" +
//                "\u0001gmm\f�=�\u001E�@\u0012���V�e*L8+r��7}�\u0015\u001E\u0010\"jk�\u0010$ҵm�7�DP\b\u0006��]�����������r}I�\u000BQ=�V1��s�˜7��,�q�\u001Cx�\u0012��\"�o$��\u00039Sj�%�E\u00009\u0015'`0����g=�-#\u000B\u0010SD�\u000BBx[�N!�'=�\u0012��:�\u0012�� �\u001C}ރ0��G\u000B��\u001F�z�t\u001DHX��P.�nD����o�\u0013eJ'M��Ը�\u0003)S@�\u0011�^�\u0011dN��'Q�k�3 �\u0012�\u000E�D�[Z(g<�^�5K�m�i�PR�]I_�ׇx9i\u0017�#�^��\u001E�9\u0005���\u001A㝫`��>t\u001D����\u0018���<\u000Fr�)24_rXSy;\u001D9�Ȭ��\u001A�e�P�x�'\u0007G�� (���5#�,\u0007�ow�PVI�t�g�T\u0012�\u001E�%\\���! �I?�֟�Y������|�E�Ax$�yo�\u0003im�\f&�kC\u0015\u0002�6\u001A�1�t7�\u0017��\r\n" +
//                "j����\u001A\r\n" +
//                "\u001E%��I\u000E\u0014�\r\n" +
//                "�\u0017V �6$\u0011�L�W\r\n" +
//                "\u0016�*��ߘ=۩\u000E�k��.䄔\u001Cy\u000F�yB�Sߋ�U�/��J��k�\u0017��J#�\u000F�H�\b�˦�\u0007�?��g�\u001D�Q��]�\r\n" +
//                "\t_��n\u0006���\u001D\u0019N��\b��\u001C��Ab}�p\b\u0014AA$\u0012��L\u001E�ʇ\u0007�\u0015&\u0004�C�\u0010\f�\"\u0014��\"++G� �I�K����h&B/t�������<>^C�,G\r\n" +
//                "Ʒv�(E�Q�s];)Hz\u0010�\u0014�\t�t\b��\u001DkR6+��r�\u0016&�\u0017��G1�!�TS�S!iB�\u0016�\u001F�߹\u0005\u0005�9�!��{\u000Exh����\u0017\u0014\u0012�ڻ\u00042�\u0002Rc�����\u0016��e9��\u0005\u0006\u0004�\u001C�\\\u000B��#���>\u0018`s����褗� (�P��Z�G0<x^�\u0007�� \u0016^����L�My*�\u001C\u000F�\u0003OGG �s�\u0010�XZ\u0002�|�\r\n" +
//                "��\u001F�B������\bo�l\u0010\u0001�^8�\u0017�Rۏ\u001E\u0004\r\n" +
//                "9#ȥ%�v�.߇���r��\u000E(^���V X�Y�)�+���n�qyV�N�%=�|���uxb\u0014l��;+A�\u0011D*wؒQ\u0016\u001F��L�\u0013^�U�]�\\x�)�u\u001D2b��1�m�F،��=�_[�r �U�\u001C�\u0000�/�e\\�a�.T�\u000B\u1F4EhU�4\b�CQ���<�U ��~/�I��U(\r\n" +
//                "��P��[�\u07BBT�#*\u000FU��*�.\u000F\u0002)q��0���Ƃ��|�\u001A1P\u0000-`\u0010\u0014aD���*om[k��\u001Ea%%�\u001B�M�R��̅q�������)�%�Vs�\u0010Q��9����攎�\bw\u00108�rM���n\u007F�+*�*�\u0019��ǝ�@�ȑ��z\"I�\u0007I^{���g5p��B�7?�\u001B$���|Ov/�Ͷvo�Gc,dT�����Ş\u001C&�{\u0019_s��{�\u0005\u0003�K�U\u0001-��'��\f8\r\n" +
//                "�\u0002J&�V\u0013�\u0004<�x\u0001,F������T��u��,M�\u0006yP\u0012y�9�HO}j=\r\n" +
//                "h.\u001F@\u0010\u0010\u0002��\u0010�\u0005�Y��\u0010N� Oc+A��=\u0019\u007F��S��\u0012n��*�cI�\u0012��h*a���ӷ�\r\n" +
//                "l��\u0012ȫ���dկ�g�sB^[�3�\u0002\r\n" +
//                "�\u001Cw�^�搓6/�r=r1\u0007�\u0018�\" �O��-D}2��&\u0016f1l���'�����3GB�)\u000F�\u001A(�d\b,\b�&�\u001E2q�p:\u0004���R����'?��S�{>%\u0003�CR����e�J}�N\u000F��M\u0011�DI\\R�>q��&89]&uR\u0014���>�9J�+��í9P~�\t�?��\u001FRBВ�~�PPO+�&�K@�SM���,�=�MJ;\u0016�c��o��V�\tam��l��7��T�?ƈ!\u0012��\u0003Ϟ��Ζ�ҸOF�˾�z���BR��&���V���D\\}(ǫ�\u000BDbd%�U�1\u000F��!�����O��\u00079\r\n" +
//                "�5��J�r��:\u0012�\u000EA�\u0002��K,�4�Ԟ*\uF736�A�\u0015!+\u001E\u000E�\u0000)��\f\r\n" +
//                "o5O�]X�b\t\u0019�as�,%gKD�T�\u0006>âf\u001F\u001C��}\u0014cn�z��\u0012�\u0011XB�&��!\r\n" +
//                "-(\u001AO����z�n�\u000Fs���x\u0003�g����lk\u001E�͉���|��E�F�XΆ浥\u0001=�����\u0012�@��0Ӽe�\u0010���1I�\u000B\u0015�B���z��{ṑ���\u0017xF�|m���������p�\u0004�l\u0010\r\n" +
//                "r�z�*�k���\u0006�%Gp,v\u0014450ix\u0007Vo$/\u0011U�}cI�\b��E����?9)^�\\\u0011�dI��\u0007�Udd�{��k�����6��JZ;\u0017�c7u���H\u000B����(�\\;�t2@\u001C<\u009C��\u0006<\f\tkū���:��q�ӝ*A� \u0005�D���w�?�c�\\{�ʉ���s���^�o�˗`������{d�ƽm�J��8]�J\u001D�\u0004�\u0013�PsK��ݵ\u0010��@K.2�U�0U$(��b�%µ� ��O�A6\u001Ag�����^5��\u0003O\u00029J���yx��w]Q�R�8�$G\f꿦H���B�6���\u0002}//D(�� ����(��[Qݥt�\u001C���\u0018H��=��\f�d��8ײ��yƈ\u001F�\b�\u0019���/\u0006��#��ɹ�]��Y�1�hmN\r\n" +
//                "��o��@�����}��\u0017�\u001EQϨ�%(\u000F�V��?��\r\n" +
//                "[�u\u0007��\u0014/����qW� �>\u0012ت\u007F���j��\r\n" +
//                "#�OR}���۔\u0015%�����m�\u0006^ȹl=��\u0014qd�k�\u001C@�e$,�˵\b\tS\u0013֟D�DN�[���u�\u0018�\u001Ers�������>o�B8g\u0011�\u0017�+�����\u0001\u000F�s�5r�!�'�I��C!��=\blK�f̼7d��Է���x�VUy|���J\f�4\t�\u0002\u0010\u000E�2\t�]=�[XM��[�O�\\h��K���6aO8\b��|�U���1猹%Pt.�\u007F�^�x�\u001Aoo���\u00070U~�e�\u001E<#�o�s\u0000&�\u0000a��\f������E1O���w������hMH�씑X \u0011B#7!\u000F�� !�f�xFk�Y\b)=\u001B\u001E5/U�IK\u000E�t\u001C/t�\u0001��e�o˞9�KVS���$��]�0��\\)��j�\u000E\u0000�CPIp��\\x\u000F*�\u052EA��R\u0017D���r��bux1�n��F�t�����*\fd%�'�� �l��g��R�|�8)\bO��\"�f>�\u0011\u0018\u0017�CR\b\"+^�)�{Bd[�:K\u0007-\u0000��g�U��\u0019$�D��k\t}�m\u0017��\u0015\u0002{I��0'k6��0Y\u001E�\u0016�2f/2J�ytY��;E��B�y��\u0004�MP�1\u0011B�$1�kR\u0017��s\u0010��䄌E�1q�Y��<0��H�R\u000E�\u000F��`���L-���!��\u0004B�m\u0018\bPn\u0004ɞ��F�iil=��Z�L\u0011!���\bws\f��᩸����9��bT�l�h��x-s\u0004���F���J\u001E撇�#6WBߥBҵ�|%í\fN�2�\u000B�\u0013o(Gxm\u0005c��U�p�|��u�\u0001�섏� �\u0004C��E�C�\u0006�\u0010�f[V��$�ڶ����� ��\u0003�B\"Q�H�x\u001Bs��,�.�\u0002©�@XEa�*�s9�) Z�I��#B��\u001D�;�bs\u0016�3�����BP���t\u001C\u0014��Xa�\u0011\bO�\u001C���s�C\u0016Z�|x��\u0013/rK:�,�9a�>[�Z��\u001Eg��\u0001��\b���)qۭzH��v�#��0��&L6\u000B\u0013Ҵ�Hõ�\r\n" +
//                "�\u0012\\_�%�\u0003b��%�\u0017���g�(/�\u001E�ྐ\u0013Eu�)\u0002h\r\n" +
//                "��x�G\u001Ee�\u0006V�Exv���oI��<6%\u0016�T\u0011��\"��#s���\u0014_\u000B��UC�!��۹\b\u001C\u000FA��<\u000F�L�%D%��1۩�EB�&���GLȨ\r\n" +
//                "=�:\u0001\\\u0004�ϸ�{�!_�\u000490\u001EԖ럗��G����jS��9 GD��̸lI\r\n" +
//                "��<a�k�L(�\u0002V�aZ��ǥ\u0005\u0000s���7(�C�\u0017�\u0007�|�\r\n" +
//                "A6�JJ������\u0013\"s���l=��8\u000E�\"��R��B\u0001�\u001C\u000B*�a\u0015��VL\b\u001Fa&�\u0004��\u001E~��\u000F��Ø)X�IH�g\u001BI�Y�\u0019�R��\u0001�c�ݼ&��U�^�x@B(�����<\u001A$��qߞ+\u0002�G����ay�\u001CfI�yGK0�H�R�B���U3\u000B\u0015�O\r\n" +
//                "�\"P2�0��q��./\u0005���7\u001E��\u001C+!��I\u0000[\u0019\"��#�1���\u0014='\u0001#�c�����/�9\u0004��SX��d���z\u000F]$$�yyrQ�$\r\n" +
//                "����\u001B�z�)$Q�V,�y�R�Go�x�Y|\t���]\u0018x�\u000B0'�� �S\u0006�P\u001E-��E$�\u0007\u0006�\u0014��\u000E\u0001<\b9\u0017�#��30p)0\bj``�`q<͉\u0007\u0006\u0006�v\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p�\u0018\u0004500p��\u007F`:��!j\u0004�\u0000\u0000\u0000\u0000IEND�B`�\r\n" +
//                "--ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i--\r\n");

        Request request = new Request.Builder()
                .url("http://10.6.134.5:8070/file/upload")
                .post(body)
                //.addHeader("content-type", "multipart/form-data; boundary=ly_JJG13qmnYkBoDZL8o4U6OValI4vatwosU_i")
                //.addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());

        //System.out.println(response.body());
/*
        String line=null;
        JSONObject resultJsonObject=null;
        StringBuilder entityStringBuilder=new StringBuilder();
        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"),8*1024);
            while ((line=b.readLine())!=null) {
                entityStringBuilder.append(line+"/n");
            }
//利用从HttpEntity中得到的String生成JsonObject

            resultJsonObject = new JSONObject(entityStringBuilder.toString());
        } catch (JSONException e) {
// TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
// TODO 自动生成的 catch 块
            e.printStackTrace();
        }
// System.out.println("***httpResponse.getEntity():"+resultJsonObject);

        System.out.println(resultJsonObject);*/
    }
}
