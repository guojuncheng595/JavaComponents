package com.gjc.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ListOption {

    /**
     * list对象中存在空值，过滤空值
     */

    public static void removeListNull() {
        //准备数据
        List<Person> personList = new ArrayList<Person>();
        Person person1 = new Person();
        person1.setName("张三");
        person1.setAge(18);
        personList.add(person1);
        Person person2 = new Person();
        person2.setName("张三");
        person2.setAge(19);
        personList.add(person2);
        Person person3 = new Person();
        person3.setName("张三");
        person3.setAge(20);
        personList.add(person3);
        Person person4 = new Person();
        person4.setName("张三");
        person4.setAge(21);
        personList.add(person4);
        personList.add(null);

        //出去空数据
        personList.stream().filter(Objects::nonNull).forEach(person -> {
            System.out.println(person.getName() + "--" + person.getAge());
        });
        System.out.println("----------------------------------------------");
        //假如personList为空，怎么判断
        Optional.ofNullable(personList).orElseGet(() -> {
            return new ArrayList<>();
        }).stream().filter(Objects::nonNull).forEach(person -> {
            System.out.println(person.getName() + "--" + person.getAge());
        });
    }

    static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        removeListNull();
    }

}
