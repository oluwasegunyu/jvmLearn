import java.net.URL;
import java.net.URLClassLoader;

public class Hello {
    public static void main(String[] args) {

        System.out.println("Hello");

        System.out.println("--------------------------------------");
        ClassLoader loader = Hello.class.getClassLoader();
        ClassLoader p1 = loader.getParent();
        ClassLoader p2 = p1.getParent();
        System.out.println("当前Hello类的默认加载器：" + loader);
        System.out.println("父类加载器: " + p1);
        System.out.println("祖父类加载器：" + p2 + "这里虽然是null，是因为这个加载器不是java语言写的故获取不到");

        System.out.println("--------------------------------------");
        System.out.println("Bootstrap 也就是祖父类加载器加载class的路径");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }

        System.out.println("--------------------------------------");
        System.out.println("System 父类加载器也就是系统类加载器加载class的路径");
        URL[] urls2 = ((URLClassLoader) ClassLoader.getSystemClassLoader().getParent()).getURLs();
        for (URL url : urls2) {
            System.out.println(url);
        }

        System.out.println("--------------------------------------");
        System.out.println("应用类加载器加载class文件的路径");
        System.out.println("可以看到这个加载器继承了上面两个类加载器的路径并包含当前项目路径");
        URL[] urls3 = ((URLClassLoader) ClassLoader.getSystemClassLoader()).getURLs();
        for (URL url : urls3) {
            System.out.println(url);
        }
    }
}
