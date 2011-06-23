import org.gnome.gdk.Event;
import org.gnome.gtk.Button;
import org.gnome.gtk.Gtk;
import org.gnome.gtk.Label;
import org.gnome.gtk.Widget;
import org.gnome.gtk.Window;
import org.gnome.gtk.WindowPosition;

public class ExampleQuit
{
    public static void main(String[] args) {
        final Window w;
        final Label l;
        final Button b;

        Gtk.init(args);
        w = new Window();
        b = new Button("Press me!");
        w.add(b);
        b.connect(new Button.Clicked() {
            public void onClicked(Button source) {	
		Gtk.mainQuit();
            }
        });
        w.setTitle("Button_Exit");
	w.setDefaultSize(250, 150);
	w.setPosition(WindowPosition.CENTER);
        w.showAll();

        w.connect(new Window.DeleteEvent() {
            public boolean onDeleteEvent(Widget source, Event event) {
                Gtk.mainQuit();
                return false;
            }
        });
	
	
        Gtk.main();
    }
}
