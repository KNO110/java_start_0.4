import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //// Задача 1: Журнал и Статьи
        Human author = new Human("Джозеф", "Джостар", "27.09.1920");
        Article article1 = new Article(author, "Кладовище вампірів", 4.7);
        Article article2 = new Article(author, "Гармонія в бою", 5.0);

        Magazine magazine = new Magazine("Бойові мистецтва", Frequency.Yearly, "07.04.1985", 30000, new Article[]{article1, article2});
        magazine.printInfo();

        ///// Задача 2: Трикутники
        Triangle triangle = new Triangle(7, 10, 5);
        triangle.printInfo();

        IsoscelesTriangle isoTriangle = new IsoscelesTriangle(8, 8, 6);
        isoTriangle.printInfo();

        //// Задача 3: Фігури
        Shape[] shapes = new Shape[]{
                new Rectangle(15, 20),
                new Circle(9),
                new RightTriangle(6, 8),
                new Trapezoid(10, 12, 7)
        };

        for (Shape shape : shapes) {
            System.out.println("Площа фігури: " + shape.calculateArea());
        }

        //// Задача 4: Музичні інструменти
        Violin violin = new Violin();
        Trombone trombone = new Trombone();
        Ukulele ukulele = new Ukulele();
        Cello cello = new Cello();

        IInfo[] instruments = new IInfo[]{violin, trombone, ukulele, cello};
        for (IInfo instrument : instruments) {
            instrument.Sound();
            instrument.Show();
            instrument.Desc();
            instrument.History();
            System.out.println();
        }
    }
}

// Людина
class Human {
    private String firstName;
    private String lastName;
    private String birthDate;

    public Human(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Дата народження: " + birthDate + ")";
    }
}

// Частота ///
enum Frequency {
    Weekly, Monthly, Yearly
}

// Стаття
class Article {
    private Human author;
    private String title;
    private double rating;

    public Article(Human author, String title, double rating) {
        this.author = author;
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Стаття: " + title + ", Автор: " + author + ", Рейтинг: " + rating;
    }
}

// Журнал
class Magazine {
    private String name;
    private Frequency frequency;
    private String releaseDate;
    private int circulation;
    private Article[] articles;

    public Magazine(String name, Frequency frequency, String releaseDate, int circulation, Article[] articles) {
        this.name = name;
        this.frequency = frequency;
        this.releaseDate = releaseDate;
        this.circulation = circulation;
        this.articles = articles;
    }

    public void printInfo() {
        System.out.println("Журнал: " + name + " (" + frequency + ")");
        System.out.println("Дата виходу: " + releaseDate);
        System.out.println("Тираж: " + circulation);
        System.out.println("Статті:");
        Arrays.stream(articles).forEach(System.out::println);
    }
}

// Трикутник
class Triangle {
    protected double sideA, sideB, sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public void printInfo() {
        System.out.println("Трикутник зі сторонами: " + sideA + ", " + sideB + ", " + sideC);
        System.out.println("Площа: " + calculateArea());
    }

    public double calculateArea() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}

// Рівнобедрений трикутник
class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double sideA, double sideB, double base) {
        super(sideA, sideB, base);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Периметр: " + (sideA + sideB + sideC));
    }
}

// Абстрактна фігура
abstract class Shape {
    public abstract double calculateArea();
}

// Прямокутник
class Rectangle extends Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// Круг
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Прямокутний трикутник
class RightTriangle extends Shape {
    private double base, height;

    public RightTriangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Трапеція
class Trapezoid extends Shape {
    private double base1, base2, height;

    public Trapezoid(double base1, double base2, double height) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * (base1 + base2) * height;
    }
}

// Інтерфейс
interface IInfo {
    void Sound();
    void Show();
    void Desc();
    void History();
}

// Музичні інструменти
abstract class MusicalInstrument implements IInfo {
    protected String name;

    public MusicalInstrument(String name) {
        this.name = name;
    }

    @Override
    public void Show() {
        System.out.println("Інструмент: " + name);
    }
}

class Violin extends MusicalInstrument {
    public Violin() {
        super("Скрипка");
    }

    @Override
    public void Sound() {
        System.out.println("Скрипка: няяяя!");
    }

    @Override
    public void Desc() {
        System.out.println("Скрипка: маленька і елегантна.");
    }

    @Override
    public void History() {
        System.out.println("Історія: створили в Італії.");
    }
}

class Trombone extends MusicalInstrument {
    public Trombone() {
        super("Тромбон");
    }

    @Override
    public void Sound() {
        System.out.println("Тромбон: ду-дуууу.");
    }

    @Override
    public void Desc() {
        System.out.println("Тромбон: великий духовий.");
    }

    @Override
    public void History() {
        System.out.println("Історія: виник у середньовіччі.");
    }
}

class Ukulele extends MusicalInstrument {
    public Ukulele() {
        super("Укулеле");
    }

    @Override
    public void Sound() {
        System.out.println("Укулеле: дзинь-дзинь.");
    }

    @Override
    public void Desc() {
        System.out.println("Укулеле: гавайська гітара.");
    }

    @Override
    public void History() {
        System.out.println("Історія: гаваї, XIX століття.");
    }
}

class Cello extends MusicalInstrument {
    public Cello() {
        super("Віолончель");
    }

    @Override
    public void Sound() {
        System.out.println("Віолончель: мрррр.");
    }

    @Override
    public void Desc() {
        System.out.println("Віолончель: грає низько.");
    }

    @Override
    public void History() {
        System.out.println("Історія: бароко.");
    }
}
