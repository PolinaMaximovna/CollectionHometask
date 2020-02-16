package ru.java.courses;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.swing.tree.TreeCellEditor;

public class CollectionHometask {

    public static void main(String[] args) {
        User user1 = new User("Tom1",20, "89518775431");
        User user2 = new User("Tom2",25,"89452175454" );
        User user3 = new User("Tom3",23, "89518885435");
        User user4 = new User("Tom1",20, "89518775481");
        User user5 = new User("Tom5",27, "89518775937");
        User user6 = new User("Tom1",20, "89111111111");

        List<User> peopleList = Arrays.asList(user1, user2, user3, user4, user5, user6);
        User userLast = task1(peopleList);
        System.out.println(userLast.name+ " - "+ userLast.age);

        // task 2
        System.out.println("Кол-во записей в справочнике - "+ task2(peopleList));
    }



    public static class User {

        private String name;
        private int age;
        private String phone;

        public User(String name, int age, String phone) {
            this.name = name;
            this.age = age;
            this.phone = phone;
        }

        public User(String phone) {
            this.phone = phone;
        }

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {

        List<String> ageNamelist = source.stream().map(x->x.name+"."+x.age).collect(Collectors.toList());
        TreeSet<String> ageNameSet = new  TreeSet<>(ageNamelist);
        String ageName = ageNameSet.last();


        User resultUser = source.stream().filter(num -> (num.name+'.'+num.age).equals(ageName)).findAny().orElse(null);
        return resultUser;
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {

//        Map<String, String> guidePhone1 = new HashMap<String, String>();
//        for(User user:source)
//        {
//            guidePhone1.put(user.getPhone(),user.getName());
//        }

        Map<String, String> guidePhone = source.stream().collect(
                Collectors.toMap(User::getPhone, User::getName,
                        (oldValue, newValue) -> oldValue));

        return guidePhone.size();
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     *
     * Нумерация полок начинается с единицы!
     */
    public static Map task3(Collection<String> source) {
        // свой код нужно писать тут
        // следующую строку можно удалять

        return null;
    }


    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {
        // свой код нужно писать тут
        // следующую строку можно удалять
        return null;
    }
}
