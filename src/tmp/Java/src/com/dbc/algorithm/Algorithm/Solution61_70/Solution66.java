package com.dbc.leecode.Algorithm.Solution61_70;

import java.util.ArrayList;

/**
 * @program: AlgorithmProject
 * @description:
 * @author: DBC
 * @create: 2020-02-04 10:46
 **/
public class Solution66 {
    public int make(char c){
        switch (c){
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

    public boolean isNumberS1(String s){
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{
                { 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}
        };
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++){
            int id = make(ss[i]);
            if(id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }

    public boolean isNumberS2(String s){
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++){
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                numberSeen = true;
                numberAfterE = true;
            }else if (s.charAt(i) == '.'){
                if(eSeen || pointSeen){
                    return false;
                }
                pointSeen = true;
            }else if (s.charAt(i) == 'e'){
                if(eSeen || !numberSeen){
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            }else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != 0 && s.charAt(i - 1) != 'e'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }

    interface NumberValidate{
        boolean validate(String s);
    }

    abstract class NumberValidateTemplate implements NumberValidate{
        public boolean validate(String s){
            if(checkStringEmpty(s)){
                return false;
            }
            s = checkAndProcessHeader(s);
            if(s.length() == 0){
                return false;
            }
            return doValidate(s);
        }

        private boolean checkStringEmpty(String s){
            if (s.equals("")){
                return true;
            }
            return false;
        }

        private String checkAndProcessHeader(String value){
            value = value.trim();

            if(value.startsWith("+") || value.startsWith("-")){
                value = value.substring(1);
            }
            return value;
        }

        protected abstract boolean doValidate(String s);
    }

    class IntegerValidate extends NumberValidateTemplate{
        @Override
        protected boolean doValidate(String integer) {
            for (int i = 0; i < integer.length(); i++){
                if(Character.isDigit(integer.charAt(i)) == false){
                    return false;
                }
            }
            return true;
        }
    }

    class SienceFormatValidate extends NumberValidateTemplate{
        @Override
        protected boolean doValidate(String s) {
            s = s.toLowerCase();
            int pos = s.indexOf("e");
            if(pos == -1){
                return false;
            }
            if(s.length() == 1){
                return false;
            }
            String first = s.substring(0, pos);
            String second = s.substring(pos + 1, s.length());

            if(validatePartBeforeE(first) == false || validatePartAfterE(second) == false){
                return false;
            }
            return true;
        }

        private boolean validatePartBeforeE(String first){
            if (first.equals("") == true){
                return false;
            }
            if(checkHeadAndEndForSpace(first) == false){
                return false;
            }
            NumberValidate integerValidate = new IntegerValidate();
            NumberValidate floatValidate = new FloatValidate();
            if(integerValidate.validate(first) == false && floatValidate.validate(first) == false){
                return false;
            }
            return true;
        }

        private boolean checkHeadAndEndForSpace(String part){
            if(part.startsWith(" ") || part.endsWith(" ")){
                return false;
            }
            return true;
        }

        private boolean validatePartAfterE(String second){
            if(second.equals("") == true){
                return false;
            }
            if(checkHeadAndEndForSpace(second) == false){
                return false;
            }
            NumberValidate integerValidate = new IntegerValidate();
            if(integerValidate.validate(second) == false){
                return false;
            }
            return true;
        }
    }

    class FloatValidate extends NumberValidateTemplate{
        @Override
        protected boolean doValidate(String floatVal) {
            int pos = floatVal.indexOf(".");
            if(pos == -1){
                return false;
            }

            if(floatVal.length() == 1){
                return false;
            }

            NumberValidate nv = new IntegerValidate();
            String first = floatVal.substring(0, pos);
            String second = floatVal.substring(pos + 1, floatVal.length());

            if(checkFirstPart(first) == true && checkFirstPart(second) == true){
                return true;
            }
            return false;
        }

        private boolean checkFirstPart(String first){
            if (first.equals("") == false && checkPart(first) == false){
                return false;
            }
            return true;
        }

        private boolean checkPart(String part){
            if(Character.isDigit(part.charAt(0)) == false || Character.isDigit(part.charAt(part.length() - 1)) == false){
                return false;
            }

            NumberValidate nv = new IntegerValidate();
            if(nv.validate(part) == false){
                return false;
            }

            return true;
        }
    }

    class NumberValidator implements NumberValidate{
        private ArrayList<NumberValidate> validators = new ArrayList<NumberValidate>();

        public NumberValidator()
        {
            addValidators();
        }

        private  void addValidators()
        {
            NumberValidate nv = new IntegerValidate();
            validators.add(nv);

            nv = new FloatValidate();
            validators.add(nv);

            /*nv = new HexValidate();
            validators.add(nv);*/

            nv = new SienceFormatValidate();
            validators.add(nv);
        }

        @Override
        public boolean validate(String s)
        {
            for (NumberValidate nv : validators)
            {
                if (nv.validate(s) == true)
                {
                    return true;
                }
            }

            return false;
        }
    }

    public boolean isNumber(String s) {
        NumberValidate nv = new NumberValidator();
        return nv.validate(s);
    }
}
