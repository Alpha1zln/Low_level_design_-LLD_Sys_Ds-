import java.util.*;
import java.io.*;

// ---------------- INTERFACES ----------------
interface DocumentElement {
    String render();
}

interface Persistence {
    void save(String data);
}

// ---------------- ELEMENTS ----------------
class TextElement implements DocumentElement {
    protected String text;
    public TextElement(String text) { this.text = text; }
    public String render() { return text; }
}

class BoldTextElement extends TextElement {
    public BoldTextElement(String text) { super(text); }
    public String render() { return "**" + text + "**"; }
}

class UnderlineTextElement extends TextElement {
    public UnderlineTextElement(String text) { super(text); }
    public String render() { return "__" + text + "__"; }
}

class ImageElement implements DocumentElement {
    private String path;
    public ImageElement(String path) { this.path = path; }
    public String render() { return "[Image:" + path + "]"; }
}

class NewLineElement implements DocumentElement {
    public String render() { return "\n"; }
}

class TabSpaceElement implements DocumentElement {
    public String render() { return "\t"; }
}

// ---------------- DOCUMENT ----------------
class Document {
    private List<DocumentElement> elements = new ArrayList<>();

    public void add(DocumentElement e) { elements.add(e); }
    public void removeLast() {
        if (!elements.isEmpty()) elements.remove(elements.size() - 1);
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        for (DocumentElement e : elements) sb.append(e.render());
        return sb.toString();
    }
}

// ---------------- STORAGE ----------------
class FileStorage implements Persistence {
    public void save(String data) {
        try (FileWriter fw = new FileWriter("document.txt")) {
            fw.write(data);
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }
}

class PDFStorage implements Persistence {
    public void save(String data) {
        try (FileWriter fw = new FileWriter("document.pdf")) {
            fw.write("PDF_CONTENT:\n" + data);
        } catch (IOException e) {
            System.out.println("Error saving PDF");
        }
    }
}

// ---------------- COMMAND PATTERN (UNDO/REDO) ----------------
interface Command {
    void execute();
    void undo();
}

class AddElementCommand implements Command {
    private Document doc;
    private DocumentElement element;

    public AddElementCommand(Document doc, DocumentElement element) {
        this.doc = doc;
        this.element = element;
    }

    public void execute() { doc.add(element); }
    public void undo() { doc.removeLast(); }
}

// ---------------- EDITOR ----------------
class DocumentEditor {
    private Document doc;
    private Persistence storage;

    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public DocumentEditor(Document doc, Persistence storage) {
        this.doc = doc;
        this.storage = storage;
    }

    private void executeCommand(Command cmd) {
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear();
        autoSave();
    }

    public void addText(String text) {
        executeCommand(new AddElementCommand(doc, new TextElement(text)));
    }

    public void addBoldText(String text) {
        executeCommand(new AddElementCommand(doc, new BoldTextElement(text)));
    }

    public void addUnderlineText(String text) {
        executeCommand(new AddElementCommand(doc, new UnderlineTextElement(text)));
    }

    public void addImage(String path) {
        executeCommand(new AddElementCommand(doc, new ImageElement(path)));
    }

    public void newLine() {
        executeCommand(new AddElementCommand(doc, new NewLineElement()));
    }

    public void tab() {
        executeCommand(new AddElementCommand(doc, new TabSpaceElement()));
    }

    // -------- UNDO --------
    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }

    // -------- REDO --------
    public void redo() {
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        }
    }

    public String render() {
        return doc.render();
    }

    public void save() {
        storage.save(render());
    }

    // -------- AUTOSAVE --------
    private void autoSave() {
        storage.save(render());
        System.out.println("[AutoSaved]");
    }
}

// ---------------- CLIENT ----------------
public class GoogleDocMain {
    public static void main(String[] args) {
        Document doc = new Document();
        Persistence fileStorage = new FileStorage();

        DocumentEditor editor = new DocumentEditor(doc, fileStorage);

        editor.addText("Hello ");
        editor.addBoldText("World");
        editor.newLine();
        editor.addUnderlineText("This is underline");

        System.out.println(editor.render());

        editor.undo();
        System.out.println("After Undo:\n" + editor.render());

        editor.redo();
        System.out.println("After Redo:\n" + editor.render());

        // Save as PDF
        Persistence pdfStorage = new PDFStorage();
        pdfStorage.save(editor.render());
    }
}



