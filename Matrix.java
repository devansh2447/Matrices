public class Matrix{

        int[] elements;
        int rows;
        int columns;

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

        public static int getSmaller(int int1, int int2){
            if(int1 > int2){
                return int2;
            }
            else{
                return int1;
            }
        }

        public static void main(String[] args){

        }
}