package com.hs;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class FactorialController {

    @RequestMapping("/factorial")
    public String greeting(@RequestParam(value="n") String number) {
        long start = System.currentTimeMillis();

        try {
            System.out.println(String.format("calculating factorial of %s", number));

            BigInteger n = new BigInteger(number);

            BigInteger fac = fac(n);

            System.out.println(String.format("calc finished, factorial of %s is %s time=%s",
                    number, fac.intValue(), (System.currentTimeMillis() - start)));

            return String.format("%s\n", fac.toString());

        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }


    private BigInteger fac(BigInteger number) {
        if (number.max(BigInteger.ONE).equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        BigInteger minusOne = number.subtract(BigInteger.ONE);

        return number.multiply(fac(minusOne));
    }
}
