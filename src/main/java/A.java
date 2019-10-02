import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class A {

    public static void main(String[] args) {

        //пытаемся подогнать пробелы так, чтоб хеши двух строк были одинаковые
        String original = "пытаемся подогнать пробелы так,";
        String non_original = "чтоб хеши двух строк были одинаковые!!!!!";

        List<Integer> listOrig = new ArrayList<>();
        List<Integer> listNonOrig = new ArrayList<>();

        boolean found = false;
        int count = 0;
        int hash_original;
        int hash_nonoriginal;

        while (!found){

            count++;

            hash_original = DigestUtils.sha256Hex(original).charAt(0);
            hash_nonoriginal = DigestUtils.sha256Hex(non_original).charAt(0);

            System.out.println("Original: " + hash_original + "Non original: "+ hash_nonoriginal);

            listOrig.add(hash_original);
            listNonOrig.add(hash_nonoriginal);

            if (Compare(listOrig, listNonOrig)){
                found = true;
            }
            else{
                original += " ";
                non_original += " ";
            }
        }

        System.out.println("End:" + count);
    }

    public static boolean Compare(List<Integer> a, List<Integer> b){

        for (Integer eA: a) {
            if (b.contains(eA))
                return true;
        }

        return false;
    }

}
