public class Matrix{

        int[] elements;
        int rows;
        int columns;

        //develop methods for multiplication
        
        public Matrix(){
            this.rows = 1;
            this.columns = 1;
            this.elements = new int[] {0};
        }

        public Matrix(int rows, int columns){
            this.rows = rows;
            this.columns = columns;
            int size = this.rows * this.columns;
            int[] assign = new int[size];
            this.elements = assign;
        }

        public Matrix(int rows, int columns, int[] elements){
            this.rows = rows;
            this.columns = columns;
            int size = this.size();
            if(size > elements.length){
                System.out.println("Array provided too small, some elements in matrix will be left as 0");
            }
            else if(size < elements.length){
                System.out.println("Array provided too large, some elements from it will be ignored");
            }
            int limit = getSmaller(size, elements.length);
            this.elements = new int[size];
            for(int iter = 0; iter < limit; iter++){
                this.elements[iter] = elements[iter];
            }
        }

        public int size(){
            return this.columns * this.rows;
        }

        public Matrix add(int add){
            Matrix forReturn = new Matrix(this.rows, this.columns);
            for(int iter = 0; iter < this.elements.length; iter++){
                forReturn.elements[iter] = this.elements[iter] + add;
            }
            return forReturn;
        }

        public Matrix add(Matrix add){
            if(add.size() != this.size()){
                return null;
            }
            else{
                Matrix forReturn = new Matrix(this.rows, this.columns);
                for(int iter = 0; iter < this.elements.length; iter++){
                    forReturn.elements[iter] = this.elements[iter] + add.elements[iter];
                }
                return forReturn;
            }
        }

        public Matrix subtract(int subtract){
            return this.add(-1 * subtract);
        }

        public Matrix subtract(Matrix subtract){
            return this.add(subtract.multiply(-1));
        }

        public Matrix multiply(int multiply){
            Matrix forReturn = new Matrix(this.rows, this.columns);
            for(int iter = 0; iter < this.size(); iter++){
                forReturn.elements[iter] = this.elements[iter] * multiply;
            }
            return forReturn;
        }

        public Matrix multiply(Matrix multiply){
            if(this.columns != multiply.rows){
                return null;
            }
            else{
                Matrix forReturn = new Matrix(this.rows, this.columns);
                int row = 1;
                int column = 1;
                for(int iter = 0; iter < forReturn.size(); iter++){
                    forReturn.elements[iter] = getProductSum(this.getRow(row), multiply.getColumn(column));
                    if((iter + 1) % this.columns == 0){
                        column = 1;
                        row++;
                    }
                    else{
                        column++;
                    }
                }
                return forReturn;
            }
        }

        public Matrix divide(int divide){
            return this.multiply(1/divide);
        }

        public Matrix divide(Matrix divide){
            return this.multiply(divide.reciprocal());
        }

        public Matrix reciprocal(){
            Matrix forReturn = new Matrix(this.rows, this.columns);
            for(int iter = 0; iter < forReturn.size(); iter++){
                forReturn.elements[iter] = 1/this.elements[iter];
            }
            return forReturn;
        }

        public static int getProductSum(int[] array1, int[] array2){
            int result = 0;
            for(int iter = 0; iter < array1.length; iter++){
                result = result + array1[iter] * array2[iter];
            }
            return result;
        }

        public int[] getRow(int rowNum){
            int[] forReturn = new int[this.columns];
            for(int iter = 0; iter < forReturn.length; iter++){
                forReturn[iter] = this.elements[rowNum + iter - 1];
            }
            return forReturn;
        }

        public int[] getColumn(int columnNum){
            int[] forReturn = new int[this.rows];
            for(int iter = 0; iter < forReturn.length; iter++){
                forReturn[iter] = this.elements[this.rows * iter + columnNum - 1];
            }
            return forReturn;
        }

        public static int getSmaller(int int1, int int2){
            if(int1 > int2){
                return int2;
            }
            else{
                return int1;
            }
        }
}