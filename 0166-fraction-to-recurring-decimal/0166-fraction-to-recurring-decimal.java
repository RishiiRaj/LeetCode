class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        sb.append(sign);
        
        long num = Math.abs((long)numerator);
        long deno = Math.abs((long)denominator);
        
        sb.append(num/deno);
        long remainder = num%deno;
        
        if(remainder == 0) return  sb.toString();
        
        sb.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        // go until repetation is not found
        while(!map.containsKey(remainder)){
            map.put(remainder, sb.length()); //key : value == remainder : its  index
            sb.append(10*remainder/deno);
            remainder = 10*remainder%deno;
        }
        int index = map.get(remainder);
        sb.insert(index,"(");
        sb.append(")");
        return sb.toString().replace("(0)","");
    }
}