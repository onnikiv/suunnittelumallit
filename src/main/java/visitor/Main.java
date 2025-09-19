package visitor;

import visitor.concrete_elements.Directory;
import visitor.concrete_elements.File;
import visitor.concrete_visitors.SearchVisitor;
import visitor.concrete_visitors.SizeCalculatorVisitor;

public class Main {

    public static void main(String[] args) {
        Directory root = new Directory("root/");

        Directory src = new Directory("src/");
        Directory docs = new Directory("docs/");
        Directory assets = new Directory("assets/");

        File mainJava = new File("Main.java", 10);
        File utilsJava = new File("Utils.java", 8);
        File readme = new File("README.md", 1);
        File logoPng = new File("logo.png", 5);
        File docPdf = new File("documentation.pdf", 15);

        root.add(src);
        root.add(docs);
        root.add(assets);
        root.add(readme);

        src.add(mainJava);
        src.add(utilsJava);
        src.add(assets);

        assets.add(logoPng);

        docs.add(docPdf);
        docs.add(readme);

        String FILETYPE = ".java";

        SearchVisitor searchVisitor = new SearchVisitor(FILETYPE);
        root.accept(searchVisitor);

        System.out.println("\nFound " + FILETYPE + " files: ");
        for (File f : searchVisitor.getFoundFiles()) {
            System.out.println(f.getName());
        }

        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        root.accept(sizeCalculatorVisitor);
        System.out.println("\nTotal size: " + sizeCalculatorVisitor.getTotalSize() + " MB");

    }

}
