public class paintJob{

    String get_details(String name,int age){
        System.out.println("My name is: "+ name);
        System.out.println("My age is: "+ age);
        return ""; 
    }
    int getBucketCount(double width,double height,double areaPerBucket,double extraBuckets){
        if (width<=0||height<=0||areaPerBucket<=0||extraBuckets<0){
            return -1;
        }
        else{
            double buckets = height*width/areaPerBucket - extraBuckets;
            System.out.println("The number of buckets Bob needs to buy before going to work is: "+buckets);
            return (int) buckets;
        }
    }
    int getBucketCount(double width,double height,double areaPerBucket){
        if (width<=0||height<=0||areaPerBucket<=0){
            return -1;
        }
        else{
            double buckets = height*width/areaPerBucket;
            System.out.println("The number of buckets Bob needs to buy before going to work is: "+buckets);
            return (int) buckets;
        }
    }

    public static void main(String[]args){
        paintJob bob = new paintJob();
        bob.getBucketCount(100, 7, 3,1);
        bob.getBucketCount(10, 10, 2);
    }
}