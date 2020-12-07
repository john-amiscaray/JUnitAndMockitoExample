public class Calculator {

    private MultiplicationService multiplier;

    public Calculator(MultiplicationService multiplier){

        this.multiplier = multiplier;

    }

    public int add(int a, int b){

       return a + b;

    }

    public double divide(int a, int b){

        if(b == 0){

            throw new IllegalArgumentException("Can't Divide by Zero");

        }

        return ((double) a) / b;

    }

    public double power(double a, double b){

        double result = 1;
        for(int i = 0; i < b; i++){

            result = multiplier.multiply(result, a);

        }
        return result;

    }


}
