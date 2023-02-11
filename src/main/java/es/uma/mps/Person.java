package es.uma.mps;

import java.util.List;

/**
 * Class representing a person with a name, age and gender.
 *
 * @author Jorge Camacho García
 */
public class Person {

    private final String name;
    private final int age;
    private final String gender; // Male, Female

    /**
     * Constructs a person with a name, age and gender.
     * Age must be positive, and gender must be 'Male' or 'Female'
     *
     * @param name the name of the person. Can't be empty.
     * @param age the age of the person. Must be greater or equal to 0.
     * @param gender the gender of the person. Must be 'Male' or 'Female'.
     */
    public Person(String name, int age, String gender) {
        if(name.isEmpty() || name.isBlank()){
            throw new BadArgumentsException("Not possible to create an unnamed person");
        }else if(age < 0){
            throw new BadArgumentsException("Not possible to create a negative aged person");
        }else if(gender.isEmpty() || gender.isBlank()){
            throw new BadArgumentsException("Not possible to create a person without gender");
        }else if(!gender.equals("Male") && !gender.equals("Female")){
            throw new BadArgumentsException("Not possible to create a person with a gender other tan 'Male' or 'Female'");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    /**
     * Computes the average age of male and female persons in a list and returns the result in
     * an array of two elements (the first element is the male mean age and the second one is the
     * female mean age)
     *
     * @param persons list of people to compute.
     * @return Array of two elements. res[0] = maleMeanAge and res[1] = femaleMeanAge
     */
    public static double[] averageAgePerGender(List<Person> persons){
        double averageMaleAge = 0.0, averageFemaleAge = 0.0;
        int  maleCounter = 0, femaleCounter = 0, totalMaleAge = 0, totalFemaleAge = 0;
        double[] result = new double[2];

        if (persons == null) {
            return new double[] {Double.NaN, Double.NaN};
        }else{
            for (Person person : persons) {
                if(person.getGender().equals("Male")){
                    maleCounter++;
                    totalMaleAge += person.getAge();
                } else if(person.getGender().equals("Female")){ // Add robustness to the method
                    femaleCounter++;
                    totalFemaleAge += person.getAge();
                }
            }

            averageMaleAge = (maleCounter>0)?((double) totalMaleAge / maleCounter):Double.NaN;
            averageFemaleAge = (femaleCounter>0)?((double) totalFemaleAge / femaleCounter):Double.NaN;

            result[0] = averageMaleAge;
            result[1] = averageFemaleAge;
        }


        return result;
    }
}
