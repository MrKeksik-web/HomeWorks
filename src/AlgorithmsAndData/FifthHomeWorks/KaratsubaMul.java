package AlgorithmsAndData.FifthHomeWorks;

import java.util.ArrayList;

public class KaratsubaMul {
    private int ans;

    public KaratsubaMul(int x,int y) {
        ArrayList<Integer> arrx = toBinary(x);
        ArrayList<Integer> arry = toBinary(y);

        int n = Math.max(arrx.size(),arry.size());
        arrx = this.extend(arrx,n);
        arry = this.extend(arry,n);

        ArrayList<Integer> res = karatsubaMul(arrx,arry);
        res = this.finalize(res);
        this.ans = this.getAnswer(res);
    }

    private ArrayList<Integer> karatsubaMul(ArrayList<Integer> x, ArrayList<Integer> y){
        int length = x.size();
        int k = length / 2;
        ArrayList<Integer> res = new ArrayList<>(length * 2);

        for(int i = res.size();i < 2 * length;i++){
            res.add(0);
        }

        int n = Math.max(x.size(),y.size());
        if(n <= 7){
            return standMul(x,y);
        }
        ArrayList<Integer> x_l = new ArrayList<>();
        ArrayList<Integer> x_r = new ArrayList<>();
        ArrayList<Integer> y_l = new ArrayList<>();
        ArrayList<Integer> y_r = new ArrayList<>();
        for(int i = 0;i < k;i++){
            x_r.add(x.get(i));
        }
        for(int i = k;i < x.size();i++){
            x_l.add(x.get(i));
        }
        for(int i = 0;i < k;i++){
            y_r.add(y.get(i));
        }
        for(int i = k;i < y.size();i++){
            y_l.add(y.get(i));
        }
        ArrayList<Integer> prod1 =  karatsubaMul(x_l,y_l);
        ArrayList<Integer> prod2 =  karatsubaMul(x_r,y_r);

        for(int i = prod1.size();i < length;i++){
            prod1.add(0);
        }
        for(int i = prod2.size();i < length;i++){
            prod2.add(0);
        }

        ArrayList<Integer> x_lr = new ArrayList<>();
        ArrayList<Integer> y_lr = new ArrayList<>();

        for(int i = 0;i < k;i++){
            x_lr.add(0);
            y_lr.add(0);
        }

        for (int i = 0; i < k; ++i) {
            x_lr.set(i,x_l.get(i) + x_r.get(i));
            y_lr.set(i,y_l.get(i) + y_r.get(i));
        }

        ArrayList<Integer> prod3 =  karatsubaMul(x_lr,y_lr);

        for(int i = prod3.size();i < length;i++){
            prod3.add(0);
        }

        for (int i = 0; i < length; ++i) {
            prod3.set(i,prod3.get(i) - ( prod2.get(i) + prod1.get(i)) );
        }

        for (int i = 0; i < length; ++i) {
            res.set(i, prod2.get(i));
        }

        for (int i = length; i < 2 * length; ++i) {
            res.set(i, prod1.get(i - length));
        }

        for (int i = k; i < length + k; ++i) {
            res.set(i,res.get(i) + prod3.get(i - k));
        }

        return res;
    }

    private ArrayList<Integer> toBinary(int x){
        String binaryLeft = Integer.toBinaryString(x);
        ArrayList<Integer> binary = new ArrayList<>();
        for(int i = binaryLeft.length() - 1;i >= 0;i--){
            binary.add(Character.getNumericValue(binaryLeft.charAt(i)));
        }
        return binary;
    }

    private ArrayList<Integer> standMul(ArrayList<Integer> x, ArrayList<Integer> y){
        int length = x.size();
        ArrayList<Integer> res = new ArrayList<>(length * 2);

        for(int i = 0;i < length * 2;i++){
            res.add(0);
        }
        for(int i = 0;i < length;i++){
            for(int j = 0;j < length;j++){
                res.set(i + j,res.get(i + j) + x.get(i) * y.get(j));
            }
        }
//        String strx = "";
//        String stry = "";
//        for(int i = x.size() - 1;i >= 0;i--){
//            strx += x.get(i) ? "1" : "0";
//            stry += y.get(i) ? "1" : "0";
//        }
//
//        int numx = Integer.parseInt(strx,2);
//        int numy = Integer.parseInt(stry,2);
//        int num = numx * numy;
//        res = this.toBinaryLeft(num);

        return res;
    }

    private int sumBinary(ArrayList<Boolean> x, ArrayList<Boolean> y){
        String xs = "";
        for(int i = 0;i < x.size();i++){
            if(x.get(i) == true){
                xs+=1;
            } else{
                xs+=0;
            }
        }
        String ys = "";
        for(int i = 0;i < y.size();i++){
            if(y.get(i) == true){
                ys+=1;
            } else{
                ys+=0;
            }
        }
        return  Integer.parseInt(xs,2) + Integer.parseInt(ys,2);
    }

    private ArrayList<Integer> extend(ArrayList<Integer> x, int length){
        while(x.size() < length){
            x.add(0);
        }
        if(x.size() % 2 != 0){
            x.add(0);
        }
        return x;
    }

    private ArrayList<Integer> finalize(ArrayList<Integer> res) {
        int l = res.size();
        res.add(0);
        for (int i = 0; i < l; ++i) {
            res.set(i + 1, res.get(i + 1) + res.get(i) / 2);
            res.set(i, res.get(i) % 2);
        }
        return res;
    }

    private int getAnswer(ArrayList<Integer> res){
        int num = 0;
        for(int i = 0;i < res.size();i++){
            num += res.get(i) != 0 ? Math.pow(2,i) : 0;
        }
        return num;
    }

    public int answer(){
        return this.ans;
    }

    public static void main(String[] args) {
        KaratsubaMul karatsubaMul = new KaratsubaMul(123,1234);
        System.out.println(karatsubaMul.answer());
    }
}
