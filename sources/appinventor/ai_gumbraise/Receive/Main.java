package appinventor.ai_gumbraise.Receive;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AppInventorCompatActivity;
import com.google.appinventor.components.runtime.BluetoothClient;
import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Clock;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListPicker;
import com.google.appinventor.components.runtime.VerticalArrangement;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.kawa.functions.CallCC;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;

/* compiled from: Main.yail */
public class Main extends Form implements Runnable {
    static final SimpleSymbol Lit0 = ((SimpleSymbol) new SimpleSymbol("Main").readResolve());
    static final SimpleSymbol Lit1 = ((SimpleSymbol) new SimpleSymbol("getMessage").readResolve());
    static final PairWithPosition Lit10 = PairWithPosition.make(Lit17, PairWithPosition.make(Lit17, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 37241), "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 37233);
    static final FString Lit100 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit101 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement4").readResolve());
    static final IntNum Lit102 = IntNum.make(16777215);
    static final FString Lit103 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit104 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit105 = ((SimpleSymbol) new SimpleSymbol("Button1").readResolve());
    static final IntNum Lit106;
    static final IntNum Lit107;
    static final FString Lit108 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit109 = ((SimpleSymbol) new SimpleSymbol("SendText").readResolve());
    static final PairWithPosition Lit11 = PairWithPosition.make(Lit17, PairWithPosition.make(Lit17, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 37076), "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 37068);
    static final PairWithPosition Lit110 = PairWithPosition.make(Lit14, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 946258);
    static final SimpleSymbol Lit111 = ((SimpleSymbol) new SimpleSymbol("ReceiveText").readResolve());
    static final SimpleSymbol Lit112 = ((SimpleSymbol) new SimpleSymbol("BytesAvailableToReceive").readResolve());
    static final PairWithPosition Lit113 = PairWithPosition.make(Lit17, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 946548);
    static final PairWithPosition Lit114 = PairWithPosition.make(Lit14, PairWithPosition.make(Lit14, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 946577), "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 946571);
    static final SimpleSymbol Lit115 = ((SimpleSymbol) new SimpleSymbol("Button1$Click").readResolve());
    static final SimpleSymbol Lit116 = ((SimpleSymbol) new SimpleSymbol("Click").readResolve());
    static final FString Lit117 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit118 = ((SimpleSymbol) new SimpleSymbol("Button2").readResolve());
    static final IntNum Lit119;
    static final PairWithPosition Lit12 = PairWithPosition.make(Lit17, PairWithPosition.make(Lit17, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 37241), "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 37233);
    static final IntNum Lit120;
    static final FString Lit121 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit122 = PairWithPosition.make(Lit14, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 1024082);
    static final PairWithPosition Lit123;
    static final PairWithPosition Lit124;
    static final SimpleSymbol Lit125 = ((SimpleSymbol) new SimpleSymbol("Button2$Click").readResolve());
    static final FString Lit126 = new FString("com.google.appinventor.components.runtime.BluetoothClient");
    static final FString Lit127 = new FString("com.google.appinventor.components.runtime.BluetoothClient");
    static final FString Lit128 = new FString("com.google.appinventor.components.runtime.Clock");
    static final FString Lit129 = new FString("com.google.appinventor.components.runtime.Clock");
    static final SimpleSymbol Lit13 = ((SimpleSymbol) new SimpleSymbol("AppName").readResolve());
    static final SimpleSymbol Lit130 = ((SimpleSymbol) new SimpleSymbol("get-simple-name").readResolve());
    static final SimpleSymbol Lit131 = ((SimpleSymbol) new SimpleSymbol("android-log-form").readResolve());
    static final SimpleSymbol Lit132 = ((SimpleSymbol) new SimpleSymbol("add-to-form-environment").readResolve());
    static final SimpleSymbol Lit133 = ((SimpleSymbol) new SimpleSymbol("lookup-in-form-environment").readResolve());
    static final SimpleSymbol Lit134 = ((SimpleSymbol) new SimpleSymbol("is-bound-in-form-environment").readResolve());
    static final SimpleSymbol Lit135 = ((SimpleSymbol) new SimpleSymbol("add-to-global-var-environment").readResolve());
    static final SimpleSymbol Lit136 = ((SimpleSymbol) new SimpleSymbol("add-to-events").readResolve());
    static final SimpleSymbol Lit137 = ((SimpleSymbol) new SimpleSymbol("add-to-components").readResolve());
    static final SimpleSymbol Lit138 = ((SimpleSymbol) new SimpleSymbol("add-to-global-vars").readResolve());
    static final SimpleSymbol Lit139 = ((SimpleSymbol) new SimpleSymbol("add-to-form-do-after-creation").readResolve());
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit140 = ((SimpleSymbol) new SimpleSymbol("send-error").readResolve());
    static final SimpleSymbol Lit141 = ((SimpleSymbol) new SimpleSymbol("dispatchEvent").readResolve());
    static final SimpleSymbol Lit142 = ((SimpleSymbol) new SimpleSymbol("dispatchGenericEvent").readResolve());
    static final SimpleSymbol Lit143 = ((SimpleSymbol) new SimpleSymbol("lookup-handler").readResolve());
    static final SimpleSymbol Lit144 = ((SimpleSymbol) new SimpleSymbol("cont").readResolve());
    static final SimpleSymbol Lit15 = ((SimpleSymbol) new SimpleSymbol("BackgroundColor").readResolve());
    static final IntNum Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18 = ((SimpleSymbol) new SimpleSymbol("ShowListsAsJson").readResolve());
    static final SimpleSymbol Lit19 = ((SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN).readResolve());
    static final SimpleSymbol Lit2 = ((SimpleSymbol) new SimpleSymbol("*the-null-value*").readResolve());
    static final SimpleSymbol Lit20 = ((SimpleSymbol) new SimpleSymbol("Sizing").readResolve());
    static final SimpleSymbol Lit21 = ((SimpleSymbol) new SimpleSymbol("Title").readResolve());
    static final SimpleSymbol Lit22 = ((SimpleSymbol) new SimpleSymbol("TitleVisible").readResolve());
    static final FString Lit23 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit24 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement1").readResolve());
    static final SimpleSymbol Lit25 = ((SimpleSymbol) new SimpleSymbol("AlignHorizontal").readResolve());
    static final IntNum Lit26 = IntNum.make(3);
    static final SimpleSymbol Lit27 = ((SimpleSymbol) new SimpleSymbol("AlignVertical").readResolve());
    static final IntNum Lit28 = IntNum.make(2);
    static final IntNum Lit29 = IntNum.make(16777215);
    static final SimpleSymbol Lit3 = ((SimpleSymbol) new SimpleSymbol("g$delayTime").readResolve());
    static final SimpleSymbol Lit30 = ((SimpleSymbol) new SimpleSymbol("Width").readResolve());
    static final IntNum Lit31 = IntNum.make(-2);
    static final FString Lit32 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit33 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit34 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement1").readResolve());
    static final IntNum Lit35 = IntNum.make(16777215);
    static final FString Lit36 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit37 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit38 = ((SimpleSymbol) new SimpleSymbol("Label2").readResolve());
    static final SimpleSymbol Lit39 = ((SimpleSymbol) new SimpleSymbol("FontSize").readResolve());
    static final IntNum Lit4 = IntNum.make(0);
    static final IntNum Lit40 = IntNum.make(28);
    static final SimpleSymbol Lit41 = ((SimpleSymbol) new SimpleSymbol("Text").readResolve());
    static final SimpleSymbol Lit42 = ((SimpleSymbol) new SimpleSymbol("TextAlignment").readResolve());
    static final IntNum Lit43 = IntNum.make(1);
    static final SimpleSymbol Lit44 = ((SimpleSymbol) new SimpleSymbol("TextColor").readResolve());
    static final IntNum Lit45;
    static final FString Lit46 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit47 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit48 = ((SimpleSymbol) new SimpleSymbol("Label1").readResolve());
    static final SimpleSymbol Lit49 = ((SimpleSymbol) new SimpleSymbol("FontTypeface").readResolve());
    static final SimpleSymbol Lit5 = ((SimpleSymbol) new SimpleSymbol("p$delay").readResolve());
    static final IntNum Lit50;
    static final FString Lit51 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit52 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit53 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement2").readResolve());
    static final IntNum Lit54 = IntNum.make(16777215);
    static final FString Lit55 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit56 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit57 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement2").readResolve());
    static final IntNum Lit58 = IntNum.make(16777215);
    static final FString Lit59 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit6 = ((SimpleSymbol) new SimpleSymbol("Clock1").readResolve());
    static final FString Lit60 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit61 = ((SimpleSymbol) new SimpleSymbol("Label3").readResolve());
    static final IntNum Lit62;
    static final FString Lit63 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit64 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit65 = ((SimpleSymbol) new SimpleSymbol("Label4").readResolve());
    static final IntNum Lit66;
    static final FString Lit67 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit68 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit69 = ((SimpleSymbol) new SimpleSymbol("HorizontalArrangement3").readResolve());
    static final SimpleSymbol Lit7 = ((SimpleSymbol) new SimpleSymbol("SystemTime").readResolve());
    static final IntNum Lit70 = IntNum.make(16777215);
    static final SimpleSymbol Lit71 = ((SimpleSymbol) new SimpleSymbol("Height").readResolve());
    static final FString Lit72 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit73 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final SimpleSymbol Lit74 = ((SimpleSymbol) new SimpleSymbol("VerticalArrangement3").readResolve());
    static final IntNum Lit75 = IntNum.make(16777215);
    static final FString Lit76 = new FString("com.google.appinventor.components.runtime.VerticalArrangement");
    static final FString Lit77 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit78 = ((SimpleSymbol) new SimpleSymbol("ListPicker1").readResolve());
    static final IntNum Lit79;
    static final IntNum Lit8 = IntNum.make(2000);
    static final IntNum Lit80 = IntNum.make(22);
    static final IntNum Lit81 = IntNum.make(75);
    static final IntNum Lit82;
    static final FString Lit83 = new FString("com.google.appinventor.components.runtime.ListPicker");
    static final SimpleSymbol Lit84 = ((SimpleSymbol) new SimpleSymbol("BluetoothClient1").readResolve());
    static final SimpleSymbol Lit85 = ((SimpleSymbol) new SimpleSymbol("Connect").readResolve());
    static final SimpleSymbol Lit86 = ((SimpleSymbol) new SimpleSymbol("Selection").readResolve());
    static final PairWithPosition Lit87 = PairWithPosition.make(Lit14, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 729208);
    static final SimpleSymbol Lit88 = ((SimpleSymbol) new SimpleSymbol("Visible").readResolve());
    static final SimpleSymbol Lit89 = ((SimpleSymbol) new SimpleSymbol("Label5").readResolve());
    static final PairWithPosition Lit9 = PairWithPosition.make(Lit17, PairWithPosition.make(Lit17, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 37076), "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 37068);
    static final SimpleSymbol Lit90 = ((SimpleSymbol) new SimpleSymbol("ListPicker1$AfterPicking").readResolve());
    static final SimpleSymbol Lit91 = ((SimpleSymbol) new SimpleSymbol("AfterPicking").readResolve());
    static final SimpleSymbol Lit92 = ((SimpleSymbol) new SimpleSymbol("Elements").readResolve());
    static final SimpleSymbol Lit93 = ((SimpleSymbol) new SimpleSymbol("AddressesAndNames").readResolve());
    static final SimpleSymbol Lit94 = ((SimpleSymbol) new SimpleSymbol("list").readResolve());
    static final SimpleSymbol Lit95 = ((SimpleSymbol) new SimpleSymbol("ListPicker1$BeforePicking").readResolve());
    static final SimpleSymbol Lit96 = ((SimpleSymbol) new SimpleSymbol("BeforePicking").readResolve());
    static final FString Lit97 = new FString("com.google.appinventor.components.runtime.Label");
    static final IntNum Lit98;
    static final FString Lit99 = new FString("com.google.appinventor.components.runtime.Label");
    public static Main Main;
    static final ModuleMethod cont$Fn4 = null;
    static final ModuleMethod cont$Fn7 = null;
    static final ModuleMethod lambda$Fn1 = null;
    static final ModuleMethod lambda$Fn10 = null;
    static final ModuleMethod lambda$Fn11 = null;
    static final ModuleMethod lambda$Fn12 = null;
    static final ModuleMethod lambda$Fn13 = null;
    static final ModuleMethod lambda$Fn14 = null;
    static final ModuleMethod lambda$Fn15 = null;
    static final ModuleMethod lambda$Fn16 = null;
    static final ModuleMethod lambda$Fn17 = null;
    static final ModuleMethod lambda$Fn18 = null;
    static final ModuleMethod lambda$Fn19 = null;
    static final ModuleMethod lambda$Fn2 = null;
    static final ModuleMethod lambda$Fn20 = null;
    static final ModuleMethod lambda$Fn21 = null;
    static final ModuleMethod lambda$Fn22 = null;
    static final ModuleMethod lambda$Fn23 = null;
    static final ModuleMethod lambda$Fn24 = null;
    static final ModuleMethod lambda$Fn25 = null;
    static final ModuleMethod lambda$Fn26 = null;
    static final ModuleMethod lambda$Fn27 = null;
    static final ModuleMethod lambda$Fn28 = null;
    static final ModuleMethod lambda$Fn29 = null;
    static final ModuleMethod lambda$Fn3 = null;
    static final ModuleMethod lambda$Fn30 = null;
    static final ModuleMethod lambda$Fn31 = null;
    static final ModuleMethod lambda$Fn32 = null;
    static final ModuleMethod lambda$Fn33 = null;
    static final ModuleMethod lambda$Fn34 = null;
    static final ModuleMethod lambda$Fn35 = null;
    static final ModuleMethod lambda$Fn36 = null;
    static final ModuleMethod lambda$Fn37 = null;
    static final ModuleMethod lambda$Fn38 = null;
    static final ModuleMethod lambda$Fn5 = null;
    static final ModuleMethod lambda$Fn6 = null;
    static final ModuleMethod lambda$Fn8 = null;
    static final ModuleMethod lambda$Fn9 = null;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public BluetoothClient BluetoothClient1;
    public Button Button1;
    public final ModuleMethod Button1$Click;
    public Button Button2;
    public final ModuleMethod Button2$Click;
    public Clock Clock1;
    public HorizontalArrangement HorizontalArrangement1;
    public HorizontalArrangement HorizontalArrangement2;
    public HorizontalArrangement HorizontalArrangement3;
    public HorizontalArrangement HorizontalArrangement4;
    public Label Label1;
    public Label Label2;
    public Label Label3;
    public Label Label4;
    public Label Label5;
    public ListPicker ListPicker1;
    public final ModuleMethod ListPicker1$AfterPicking;
    public final ModuleMethod ListPicker1$BeforePicking;
    public VerticalArrangement VerticalArrangement1;
    public VerticalArrangement VerticalArrangement2;
    public VerticalArrangement VerticalArrangement3;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public final ModuleMethod dispatchGenericEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public final ModuleMethod get$Mnsimple$Mnname;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod onCreate;
    public final ModuleMethod process$Mnexception;
    public final ModuleMethod send$Mnerror;

    /* compiled from: Main.yail */
    public class frame extends ModuleBody {
        Main $main = this;

        public Object apply0(ModuleMethod moduleMethod) {
            switch (moduleMethod.selector) {
                case 18:
                    return Main.lambda2();
                case 19:
                    this.$main.$define();
                    return Values.empty;
                case 20:
                    return Main.lambda3();
                case 22:
                    return Main.lambda4();
                case 24:
                    return Main.lambda7();
                case 25:
                    return Main.lambda6();
                case 26:
                    return Main.lambda9();
                case 27:
                    return Main.lambda10();
                case 28:
                    return Main.lambda11();
                case 29:
                    return Main.lambda12();
                case 30:
                    return Main.lambda13();
                case 31:
                    return Main.lambda14();
                case 32:
                    return Main.lambda15();
                case 33:
                    return Main.lambda16();
                case 34:
                    return Main.lambda17();
                case 35:
                    return Main.lambda18();
                case 36:
                    return Main.lambda19();
                case 37:
                    return Main.lambda20();
                case 38:
                    return Main.lambda21();
                case 39:
                    return Main.lambda22();
                case 40:
                    return Main.lambda23();
                case 41:
                    return Main.lambda24();
                case 42:
                    return Main.lambda25();
                case 43:
                    return Main.lambda26();
                case 44:
                    return Main.lambda27();
                case 45:
                    return Main.lambda28();
                case 46:
                    return Main.lambda29();
                case 47:
                    return Main.lambda30();
                case 48:
                    return Main.lambda31();
                case 49:
                    return this.$main.ListPicker1$AfterPicking();
                case 50:
                    return this.$main.ListPicker1$BeforePicking();
                case 51:
                    return Main.lambda32();
                case 52:
                    return Main.lambda33();
                case 53:
                    return Main.lambda34();
                case 54:
                    return Main.lambda35();
                case 55:
                    return Main.lambda36();
                case 56:
                    return Main.lambda37();
                case 57:
                    return this.$main.Button1$Click();
                case 58:
                    return Main.lambda38();
                case 59:
                    return Main.lambda39();
                case 60:
                    return this.$main.Button2$Click();
                default:
                    return super.apply0(moduleMethod);
            }
        }

        public int match0(ModuleMethod moduleMethod, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 18:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 19:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 20:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 22:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 24:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 25:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 26:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 27:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 28:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 29:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 30:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 31:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 32:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 33:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 34:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 35:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 36:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 37:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 38:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 39:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 40:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 41:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 42:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 43:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 44:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 45:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 46:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 47:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 48:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 49:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 50:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 51:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 52:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 53:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 54:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 55:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 56:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 57:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 58:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 59:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                case 60:
                    callContext.proc = moduleMethod;
                    callContext.pc = 0;
                    return 0;
                default:
                    return super.match0(moduleMethod, callContext);
            }
        }

        public int match1(ModuleMethod moduleMethod, Object obj, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 1:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 2:
                    if (!(obj instanceof Main)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 3:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 7:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 12:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 13:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 14:
                    if (!(obj instanceof Main)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 21:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                case 23:
                    callContext.value1 = obj;
                    callContext.proc = moduleMethod;
                    callContext.pc = 1;
                    return 0;
                default:
                    return super.match1(moduleMethod, obj, callContext);
            }
        }

        public int match2(ModuleMethod moduleMethod, Object obj, Object obj2, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 4:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 5:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 8:
                    if (!(obj instanceof Symbol)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 9:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 11:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                case 17:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.proc = moduleMethod;
                    callContext.pc = 2;
                    return 0;
                default:
                    return super.match2(moduleMethod, obj, obj2, callContext);
            }
        }

        public int match4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4, CallContext callContext) {
            switch (moduleMethod.selector) {
                case 10:
                    callContext.value1 = obj;
                    callContext.value2 = obj2;
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 15:
                    if (!(obj instanceof Main)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    if (!(obj4 instanceof String)) {
                        return -786428;
                    }
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                case 16:
                    if (!(obj instanceof Main)) {
                        return -786431;
                    }
                    callContext.value1 = obj;
                    if (!(obj2 instanceof Component)) {
                        return -786430;
                    }
                    callContext.value2 = obj2;
                    if (!(obj3 instanceof String)) {
                        return -786429;
                    }
                    callContext.value3 = obj3;
                    callContext.value4 = obj4;
                    callContext.proc = moduleMethod;
                    callContext.pc = 4;
                    return 0;
                default:
                    return super.match4(moduleMethod, obj, obj2, obj3, obj4, callContext);
            }
        }

        public Object apply1(ModuleMethod moduleMethod, Object obj) {
            switch (moduleMethod.selector) {
                case 1:
                    return this.$main.getSimpleName(obj);
                case 2:
                    try {
                        this.$main.onCreate((Bundle) obj);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "onCreate", 1, obj);
                    }
                case 3:
                    this.$main.androidLogForm(obj);
                    return Values.empty;
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 7:
                    try {
                        return this.$main.isBoundInFormEnvironment((Symbol) obj) ? Boolean.TRUE : Boolean.FALSE;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "is-bound-in-form-environment", 1, obj);
                    }
                case 12:
                    this.$main.addToFormDoAfterCreation(obj);
                    return Values.empty;
                case 13:
                    this.$main.sendError(obj);
                    return Values.empty;
                case 14:
                    this.$main.processException(obj);
                    return Values.empty;
                case 21:
                    return Main.lambda5cont(obj);
                case 23:
                    return Main.lambda8cont(obj);
                default:
                    return super.apply1(moduleMethod, obj);
            }
        }

        public Object apply4(ModuleMethod moduleMethod, Object obj, Object obj2, Object obj3, Object obj4) {
            boolean z = true;
            switch (moduleMethod.selector) {
                case 10:
                    this.$main.addToComponents(obj, obj2, obj3, obj4);
                    return Values.empty;
                case 15:
                    try {
                        try {
                            try {
                                try {
                                    return this.$main.dispatchEvent((Component) obj, (String) obj2, (String) obj3, (Object[]) obj4) ? Boolean.TRUE : Boolean.FALSE;
                                } catch (ClassCastException e) {
                                    throw new WrongType(e, "dispatchEvent", 4, obj4);
                                }
                            } catch (ClassCastException e2) {
                                throw new WrongType(e2, "dispatchEvent", 3, obj3);
                            }
                        } catch (ClassCastException e3) {
                            throw new WrongType(e3, "dispatchEvent", 2, obj2);
                        }
                    } catch (ClassCastException e4) {
                        throw new WrongType(e4, "dispatchEvent", 1, obj);
                    }
                case 16:
                    Main main = this.$main;
                    try {
                        Component component = (Component) obj;
                        try {
                            String str = (String) obj2;
                            try {
                                if (obj3 == Boolean.FALSE) {
                                    z = false;
                                }
                                try {
                                    main.dispatchGenericEvent(component, str, z, (Object[]) obj4);
                                    return Values.empty;
                                } catch (ClassCastException e5) {
                                    throw new WrongType(e5, "dispatchGenericEvent", 4, obj4);
                                }
                            } catch (ClassCastException e6) {
                                throw new WrongType(e6, "dispatchGenericEvent", 3, obj3);
                            }
                        } catch (ClassCastException e7) {
                            throw new WrongType(e7, "dispatchGenericEvent", 2, obj2);
                        }
                    } catch (ClassCastException e8) {
                        throw new WrongType(e8, "dispatchGenericEvent", 1, obj);
                    }
                default:
                    return super.apply4(moduleMethod, obj, obj2, obj3, obj4);
            }
        }

        public Object apply2(ModuleMethod moduleMethod, Object obj, Object obj2) {
            switch (moduleMethod.selector) {
                case 4:
                    try {
                        this.$main.addToFormEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e) {
                        throw new WrongType(e, "add-to-form-environment", 1, obj);
                    }
                case 5:
                    try {
                        return this.$main.lookupInFormEnvironment((Symbol) obj, obj2);
                    } catch (ClassCastException e2) {
                        throw new WrongType(e2, "lookup-in-form-environment", 1, obj);
                    }
                case 8:
                    try {
                        this.$main.addToGlobalVarEnvironment((Symbol) obj, obj2);
                        return Values.empty;
                    } catch (ClassCastException e3) {
                        throw new WrongType(e3, "add-to-global-var-environment", 1, obj);
                    }
                case 9:
                    this.$main.addToEvents(obj, obj2);
                    return Values.empty;
                case 11:
                    this.$main.addToGlobalVars(obj, obj2);
                    return Values.empty;
                case 17:
                    return this.$main.lookupHandler(obj, obj2);
                default:
                    return super.apply2(moduleMethod, obj, obj2);
            }
        }
    }

    static {
        SimpleSymbol simpleSymbol = (SimpleSymbol) new SimpleSymbol(PropertyTypeConstants.PROPERTY_TYPE_TEXT).readResolve();
        Lit14 = simpleSymbol;
        Lit124 = PairWithPosition.make(simpleSymbol, PairWithPosition.make(Lit14, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 1024395), "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 1024389);
        SimpleSymbol simpleSymbol2 = (SimpleSymbol) new SimpleSymbol("number").readResolve();
        Lit17 = simpleSymbol2;
        Lit123 = PairWithPosition.make(simpleSymbol2, LList.Empty, "/tmp/1577910358808_0.4388497525813194-0/youngandroidproject/../src/appinventor/ai_gumbraise/Receive/Main.yail", 1024372);
        int[] iArr = new int[2];
        iArr[0] = -1;
        Lit120 = IntNum.make(iArr);
        int[] iArr2 = new int[2];
        iArr2[0] = -15856114;
        Lit119 = IntNum.make(iArr2);
        int[] iArr3 = new int[2];
        iArr3[0] = -1;
        Lit107 = IntNum.make(iArr3);
        int[] iArr4 = new int[2];
        iArr4[0] = -15856114;
        Lit106 = IntNum.make(iArr4);
        int[] iArr5 = new int[2];
        iArr5[0] = -15329770;
        Lit98 = IntNum.make(iArr5);
        int[] iArr6 = new int[2];
        iArr6[0] = -1;
        Lit82 = IntNum.make(iArr6);
        int[] iArr7 = new int[2];
        iArr7[0] = -15856114;
        Lit79 = IntNum.make(iArr7);
        int[] iArr8 = new int[2];
        iArr8[0] = -1;
        Lit66 = IntNum.make(iArr8);
        int[] iArr9 = new int[2];
        iArr9[0] = -1;
        Lit62 = IntNum.make(iArr9);
        int[] iArr10 = new int[2];
        iArr10[0] = -1;
        Lit50 = IntNum.make(iArr10);
        int[] iArr11 = new int[2];
        iArr11[0] = -1;
        Lit45 = IntNum.make(iArr11);
        int[] iArr12 = new int[2];
        iArr12[0] = -16777216;
        Lit16 = IntNum.make(iArr12);
    }

    public Main() {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        this.get$Mnsimple$Mnname = new ModuleMethod(frame2, 1, Lit130, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.onCreate = new ModuleMethod(frame2, 2, "onCreate", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.android$Mnlog$Mnform = new ModuleMethod(frame2, 3, Lit131, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 4, Lit132, 8194);
        this.lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 5, Lit133, 8193);
        this.is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 7, Lit134, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 8, Lit135, 8194);
        this.add$Mnto$Mnevents = new ModuleMethod(frame2, 9, Lit136, 8194);
        this.add$Mnto$Mncomponents = new ModuleMethod(frame2, 10, Lit137, 16388);
        this.add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 11, Lit138, 8194);
        this.add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 12, Lit139, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.send$Mnerror = new ModuleMethod(frame2, 13, Lit140, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.process$Mnexception = new ModuleMethod(frame2, 14, "process-exception", FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        this.dispatchEvent = new ModuleMethod(frame2, 15, Lit141, 16388);
        this.dispatchGenericEvent = new ModuleMethod(frame2, 16, Lit142, 16388);
        this.lookup$Mnhandler = new ModuleMethod(frame2, 17, Lit143, 8194);
        ModuleMethod moduleMethod = new ModuleMethod(frame2, 18, null, 0);
        moduleMethod.setProperty("source-location", "/tmp/runtime7690172437445195639.scm:622");
        lambda$Fn1 = moduleMethod;
        this.$define = new ModuleMethod(frame2, 19, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 20, null, 0);
        cont$Fn4 = new ModuleMethod(frame2, 21, Lit144, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        lambda$Fn3 = new ModuleMethod(frame2, 22, null, 0);
        cont$Fn7 = new ModuleMethod(frame2, 23, Lit144, FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        lambda$Fn6 = new ModuleMethod(frame2, 24, null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 25, null, 0);
        lambda$Fn8 = new ModuleMethod(frame2, 26, null, 0);
        lambda$Fn9 = new ModuleMethod(frame2, 27, null, 0);
        lambda$Fn10 = new ModuleMethod(frame2, 28, null, 0);
        lambda$Fn11 = new ModuleMethod(frame2, 29, null, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 30, null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 31, null, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 32, null, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 33, null, 0);
        lambda$Fn16 = new ModuleMethod(frame2, 34, null, 0);
        lambda$Fn17 = new ModuleMethod(frame2, 35, null, 0);
        lambda$Fn18 = new ModuleMethod(frame2, 36, null, 0);
        lambda$Fn19 = new ModuleMethod(frame2, 37, null, 0);
        lambda$Fn20 = new ModuleMethod(frame2, 38, null, 0);
        lambda$Fn21 = new ModuleMethod(frame2, 39, null, 0);
        lambda$Fn22 = new ModuleMethod(frame2, 40, null, 0);
        lambda$Fn23 = new ModuleMethod(frame2, 41, null, 0);
        lambda$Fn24 = new ModuleMethod(frame2, 42, null, 0);
        lambda$Fn25 = new ModuleMethod(frame2, 43, null, 0);
        lambda$Fn26 = new ModuleMethod(frame2, 44, null, 0);
        lambda$Fn27 = new ModuleMethod(frame2, 45, null, 0);
        lambda$Fn28 = new ModuleMethod(frame2, 46, null, 0);
        lambda$Fn29 = new ModuleMethod(frame2, 47, null, 0);
        lambda$Fn30 = new ModuleMethod(frame2, 48, null, 0);
        this.ListPicker1$AfterPicking = new ModuleMethod(frame2, 49, Lit90, 0);
        this.ListPicker1$BeforePicking = new ModuleMethod(frame2, 50, Lit95, 0);
        lambda$Fn31 = new ModuleMethod(frame2, 51, null, 0);
        lambda$Fn32 = new ModuleMethod(frame2, 52, null, 0);
        lambda$Fn33 = new ModuleMethod(frame2, 53, null, 0);
        lambda$Fn34 = new ModuleMethod(frame2, 54, null, 0);
        lambda$Fn35 = new ModuleMethod(frame2, 55, null, 0);
        lambda$Fn36 = new ModuleMethod(frame2, 56, null, 0);
        this.Button1$Click = new ModuleMethod(frame2, 57, Lit115, 0);
        lambda$Fn37 = new ModuleMethod(frame2, 58, null, 0);
        lambda$Fn38 = new ModuleMethod(frame2, 59, null, 0);
        this.Button2$Click = new ModuleMethod(frame2, 60, Lit125, 0);
    }

    public Object lookupInFormEnvironment(Symbol symbol) {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public void run() {
        CallContext instance = CallContext.getInstance();
        Consumer consumer = instance.consumer;
        instance.consumer = VoidConsumer.instance;
        try {
            run(instance);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        ModuleBody.runCleanup(instance, th, consumer);
    }

    public final void run(CallContext $ctx) {
        String obj;
        Consumer $result = $ctx.consumer;
        runtime.$instance.run();
        this.$Stdebug$Mnform$St = Boolean.FALSE;
        this.form$Mnenvironment = Environment.make(misc.symbol$To$String(Lit0));
        FString stringAppend = strings.stringAppend(misc.symbol$To$String(Lit0), "-global-vars");
        if (stringAppend == null) {
            obj = null;
        } else {
            obj = stringAppend.toString();
        }
        this.global$Mnvar$Mnenvironment = Environment.make(obj);
        Main = null;
        this.form$Mnname$Mnsymbol = Lit0;
        this.events$Mnto$Mnregister = LList.Empty;
        this.components$Mnto$Mncreate = LList.Empty;
        this.global$Mnvars$Mnto$Mncreate = LList.Empty;
        this.form$Mndo$Mnafter$Mncreation = LList.Empty;
        runtime.$instance.run();
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit3, Lit4), $result);
        } else {
            addToGlobalVars(Lit3, lambda$Fn2);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit5, lambda$Fn3), $result);
        } else {
            addToGlobalVars(Lit5, lambda$Fn5);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.setAndCoerceProperty$Ex(Lit0, Lit13, "Receive", Lit14);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Lit16, Lit17);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit18, Boolean.TRUE, Lit19);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit20, "Fixed", Lit14);
            runtime.setAndCoerceProperty$Ex(Lit0, Lit21, "Main", Lit14);
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit22, Boolean.FALSE, Lit19), $result);
        } else {
            addToFormDoAfterCreation(new Promise(lambda$Fn8));
        }
        this.HorizontalArrangement1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit23, Lit24, lambda$Fn9), $result);
        } else {
            addToComponents(Lit0, Lit32, Lit24, lambda$Fn10);
        }
        this.VerticalArrangement1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit24, Lit33, Lit34, lambda$Fn11), $result);
        } else {
            addToComponents(Lit24, Lit36, Lit34, lambda$Fn12);
        }
        this.Label2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit34, Lit37, Lit38, lambda$Fn13), $result);
        } else {
            addToComponents(Lit34, Lit46, Lit38, lambda$Fn14);
        }
        this.Label1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit34, Lit47, Lit48, lambda$Fn15), $result);
        } else {
            addToComponents(Lit34, Lit51, Lit48, lambda$Fn16);
        }
        this.HorizontalArrangement2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit52, Lit53, lambda$Fn17), $result);
        } else {
            addToComponents(Lit0, Lit55, Lit53, lambda$Fn18);
        }
        this.VerticalArrangement2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit53, Lit56, Lit57, lambda$Fn19), $result);
        } else {
            addToComponents(Lit53, Lit59, Lit57, lambda$Fn20);
        }
        this.Label3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit57, Lit60, Lit61, lambda$Fn21), $result);
        } else {
            addToComponents(Lit57, Lit63, Lit61, lambda$Fn22);
        }
        this.Label4 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit57, Lit64, Lit65, lambda$Fn23), $result);
        } else {
            addToComponents(Lit57, Lit67, Lit65, lambda$Fn24);
        }
        this.HorizontalArrangement3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit68, Lit69, lambda$Fn25), $result);
        } else {
            addToComponents(Lit0, Lit72, Lit69, lambda$Fn26);
        }
        this.VerticalArrangement3 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit69, Lit73, Lit74, lambda$Fn27), $result);
        } else {
            addToComponents(Lit69, Lit76, Lit74, lambda$Fn28);
        }
        this.ListPicker1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit74, Lit77, Lit78, lambda$Fn29), $result);
        } else {
            addToComponents(Lit74, Lit83, Lit78, lambda$Fn30);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit90, this.ListPicker1$AfterPicking);
        } else {
            addToFormEnvironment(Lit90, this.ListPicker1$AfterPicking);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "ListPicker1", "AfterPicking");
        } else {
            addToEvents(Lit78, Lit91);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit95, this.ListPicker1$BeforePicking);
        } else {
            addToFormEnvironment(Lit95, this.ListPicker1$BeforePicking);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "ListPicker1", "BeforePicking");
        } else {
            addToEvents(Lit78, Lit96);
        }
        this.Label5 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit74, Lit97, Lit89, lambda$Fn31), $result);
        } else {
            addToComponents(Lit74, Lit99, Lit89, lambda$Fn32);
        }
        this.HorizontalArrangement4 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit74, Lit100, Lit101, lambda$Fn33), $result);
        } else {
            addToComponents(Lit74, Lit103, Lit101, lambda$Fn34);
        }
        this.Button1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit101, Lit104, Lit105, lambda$Fn35), $result);
        } else {
            addToComponents(Lit101, Lit108, Lit105, lambda$Fn36);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit115, this.Button1$Click);
        } else {
            addToFormEnvironment(Lit115, this.Button1$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button1", "Click");
        } else {
            addToEvents(Lit105, Lit116);
        }
        this.Button2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit101, Lit117, Lit118, lambda$Fn37), $result);
        } else {
            addToComponents(Lit101, Lit121, Lit118, lambda$Fn38);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            runtime.addToCurrentFormEnvironment(Lit125, this.Button2$Click);
        } else {
            addToFormEnvironment(Lit125, this.Button2$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching) runtime.$Stthis$Mnform$St, "Button2", "Click");
        } else {
            addToEvents(Lit118, Lit116);
        }
        this.BluetoothClient1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit126, Lit84, Boolean.FALSE), $result);
        } else {
            addToComponents(Lit0, Lit127, Lit84, Boolean.FALSE);
        }
        this.Clock1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE) {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit128, Lit6, Boolean.FALSE), $result);
        } else {
            addToComponents(Lit0, Lit129, Lit6, Boolean.FALSE);
        }
        runtime.initRuntime();
    }

    static IntNum lambda3() {
        return Lit4;
    }

    static Object lambda4() {
        runtime.addGlobalVarToCurrentFormEnvironment(Lit3, runtime.callComponentMethod(Lit6, Lit7, LList.Empty, LList.Empty));
        runtime.addGlobalVarToCurrentFormEnvironment(Lit3, runtime.callYailPrimitive(AddOp.$Pl, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), Lit8), Lit9, "+"));
        ModuleMethod moduleMethod = cont$Fn4;
        return CallCC.callcc.apply1(cont$Fn4);
    }

    public static Object lambda5cont(Object $Styail$Mnbreak$St) {
        do {
        } while (runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.callComponentMethod(Lit6, Lit7, LList.Empty, LList.Empty), runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit10, "<") != Boolean.FALSE);
        return null;
    }

    static Procedure lambda6() {
        return lambda$Fn6;
    }

    static Object lambda7() {
        runtime.addGlobalVarToCurrentFormEnvironment(Lit3, runtime.callComponentMethod(Lit6, Lit7, LList.Empty, LList.Empty));
        runtime.addGlobalVarToCurrentFormEnvironment(Lit3, runtime.callYailPrimitive(AddOp.$Pl, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), Lit8), Lit11, "+"));
        ModuleMethod moduleMethod = cont$Fn7;
        return CallCC.callcc.apply1(cont$Fn7);
    }

    public static Object lambda8cont(Object $Styail$Mnbreak$St) {
        do {
        } while (runtime.callYailPrimitive(Scheme.numLss, LList.list2(runtime.callComponentMethod(Lit6, Lit7, LList.Empty, LList.Empty), runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit12, "<") != Boolean.FALSE);
        return null;
    }

    static Object lambda9() {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit13, "Receive", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit15, Lit16, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit18, Boolean.TRUE, Lit19);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit20, "Fixed", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit0, Lit21, "Main", Lit14);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit22, Boolean.FALSE, Lit19);
    }

    static Object lambda10() {
        runtime.setAndCoerceProperty$Ex(Lit24, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit24, Lit27, Lit28, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit24, Lit15, Lit29, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit24, Lit30, Lit31, Lit17);
    }

    static Object lambda11() {
        runtime.setAndCoerceProperty$Ex(Lit24, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit24, Lit27, Lit28, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit24, Lit15, Lit29, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit24, Lit30, Lit31, Lit17);
    }

    static Object lambda12() {
        runtime.setAndCoerceProperty$Ex(Lit34, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit27, Lit28, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit15, Lit35, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit34, Lit30, Lit31, Lit17);
    }

    static Object lambda13() {
        runtime.setAndCoerceProperty$Ex(Lit34, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit27, Lit28, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit34, Lit15, Lit35, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit34, Lit30, Lit31, Lit17);
    }

    static Object lambda14() {
        runtime.setAndCoerceProperty$Ex(Lit38, Lit39, Lit40, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit41, "Température", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit42, Lit43, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit38, Lit44, Lit45, Lit17);
    }

    static Object lambda15() {
        runtime.setAndCoerceProperty$Ex(Lit38, Lit39, Lit40, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit41, "Température", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit38, Lit42, Lit43, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit38, Lit44, Lit45, Lit17);
    }

    static Object lambda16() {
        runtime.setAndCoerceProperty$Ex(Lit48, Lit39, Lit40, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit49, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit41, "0°C", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit42, Lit43, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit44, Lit50, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit48, Lit30, Lit31, Lit17);
    }

    static Object lambda17() {
        runtime.setAndCoerceProperty$Ex(Lit48, Lit39, Lit40, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit49, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit41, "0°C", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit42, Lit43, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit48, Lit44, Lit50, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit48, Lit30, Lit31, Lit17);
    }

    static Object lambda18() {
        runtime.setAndCoerceProperty$Ex(Lit53, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit53, Lit27, Lit28, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit53, Lit15, Lit54, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit53, Lit30, Lit31, Lit17);
    }

    static Object lambda19() {
        runtime.setAndCoerceProperty$Ex(Lit53, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit53, Lit27, Lit28, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit53, Lit15, Lit54, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit53, Lit30, Lit31, Lit17);
    }

    static Object lambda20() {
        runtime.setAndCoerceProperty$Ex(Lit57, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit27, Lit28, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit15, Lit58, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit57, Lit30, Lit31, Lit17);
    }

    static Object lambda21() {
        runtime.setAndCoerceProperty$Ex(Lit57, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit27, Lit28, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit57, Lit15, Lit58, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit57, Lit30, Lit31, Lit17);
    }

    static Object lambda22() {
        runtime.setAndCoerceProperty$Ex(Lit61, Lit39, Lit40, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit61, Lit41, "Humidité", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit61, Lit42, Lit43, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit61, Lit44, Lit62, Lit17);
    }

    static Object lambda23() {
        runtime.setAndCoerceProperty$Ex(Lit61, Lit39, Lit40, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit61, Lit41, "Humidité", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit61, Lit42, Lit43, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit61, Lit44, Lit62, Lit17);
    }

    static Object lambda24() {
        runtime.setAndCoerceProperty$Ex(Lit65, Lit39, Lit40, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit65, Lit49, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit65, Lit41, "0%", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit65, Lit42, Lit43, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit65, Lit44, Lit66, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit65, Lit30, Lit31, Lit17);
    }

    static Object lambda25() {
        runtime.setAndCoerceProperty$Ex(Lit65, Lit39, Lit40, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit65, Lit49, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit65, Lit41, "0%", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit65, Lit42, Lit43, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit65, Lit44, Lit66, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit65, Lit30, Lit31, Lit17);
    }

    static Object lambda26() {
        runtime.setAndCoerceProperty$Ex(Lit69, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit27, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit15, Lit70, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit71, Lit31, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit69, Lit30, Lit31, Lit17);
    }

    static Object lambda27() {
        runtime.setAndCoerceProperty$Ex(Lit69, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit27, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit15, Lit70, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit69, Lit71, Lit31, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit69, Lit30, Lit31, Lit17);
    }

    static Object lambda28() {
        runtime.setAndCoerceProperty$Ex(Lit74, Lit27, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit74, Lit15, Lit75, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit74, Lit71, Lit31, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit74, Lit30, Lit31, Lit17);
    }

    static Object lambda29() {
        runtime.setAndCoerceProperty$Ex(Lit74, Lit27, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit74, Lit15, Lit75, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit74, Lit71, Lit31, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit74, Lit30, Lit31, Lit17);
    }

    static Object lambda30() {
        runtime.setAndCoerceProperty$Ex(Lit78, Lit15, Lit79, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit78, Lit39, Lit80, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit78, Lit71, Lit81, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit78, Lit41, "Se connecter", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit78, Lit44, Lit82, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit78, Lit30, Lit31, Lit17);
    }

    static Object lambda31() {
        runtime.setAndCoerceProperty$Ex(Lit78, Lit15, Lit79, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit78, Lit39, Lit80, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit78, Lit71, Lit81, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit78, Lit41, "Se connecter", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit78, Lit44, Lit82, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit78, Lit30, Lit31, Lit17);
    }

    public Object ListPicker1$AfterPicking() {
        runtime.setThisForm();
        if (runtime.callComponentMethod(Lit84, Lit85, LList.list1(runtime.get$Mnproperty.apply2(Lit78, Lit86)), Lit87) == Boolean.FALSE) {
            return Values.empty;
        }
        runtime.setAndCoerceProperty$Ex(Lit78, Lit88, Boolean.FALSE, Lit19);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit88, Boolean.TRUE, Lit19);
        return runtime.setAndCoerceProperty$Ex(Lit89, Lit41, runtime.get$Mnproperty.apply2(Lit78, Lit86), Lit14);
    }

    public Object ListPicker1$BeforePicking() {
        runtime.setThisForm();
        return runtime.setAndCoerceProperty$Ex(Lit78, Lit92, runtime.get$Mnproperty.apply2(Lit84, Lit93), Lit94);
    }

    static Object lambda32() {
        runtime.setAndCoerceProperty$Ex(Lit89, Lit39, Lit80, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit41, "Text for Label5", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit42, Lit43, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit44, Lit98, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit88, Boolean.FALSE, Lit19);
        return runtime.setAndCoerceProperty$Ex(Lit89, Lit30, Lit31, Lit17);
    }

    static Object lambda33() {
        runtime.setAndCoerceProperty$Ex(Lit89, Lit39, Lit80, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit41, "Text for Label5", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit42, Lit43, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit44, Lit98, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit89, Lit88, Boolean.FALSE, Lit19);
        return runtime.setAndCoerceProperty$Ex(Lit89, Lit30, Lit31, Lit17);
    }

    static Object lambda34() {
        runtime.setAndCoerceProperty$Ex(Lit101, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit101, Lit27, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit101, Lit15, Lit102, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit101, Lit71, Lit31, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit101, Lit30, Lit31, Lit17);
    }

    static Object lambda35() {
        runtime.setAndCoerceProperty$Ex(Lit101, Lit25, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit101, Lit27, Lit26, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit101, Lit15, Lit102, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit101, Lit71, Lit31, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit101, Lit30, Lit31, Lit17);
    }

    static Object lambda36() {
        runtime.setAndCoerceProperty$Ex(Lit105, Lit15, Lit106, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit105, Lit39, Lit80, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit105, Lit71, Lit81, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit105, Lit41, "Actualiser la température", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit105, Lit44, Lit107, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit105, Lit30, Lit31, Lit17);
    }

    static Object lambda37() {
        runtime.setAndCoerceProperty$Ex(Lit105, Lit15, Lit106, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit105, Lit39, Lit80, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit105, Lit71, Lit81, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit105, Lit41, "Actualiser la température", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit105, Lit44, Lit107, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit105, Lit30, Lit31, Lit17);
    }

    public Object Button1$Click() {
        runtime.setThisForm();
        runtime.callComponentMethod(Lit84, Lit109, LList.list1("T"), Lit110);
        Scheme.applyToArgs.apply1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St));
        return runtime.setAndCoerceProperty$Ex(Lit48, Lit41, runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.callComponentMethod(Lit84, Lit111, LList.list1(runtime.callComponentMethod(Lit84, Lit112, LList.Empty, LList.Empty)), Lit113), "°C"), Lit114, "join"), Lit14);
    }

    static Object lambda38() {
        runtime.setAndCoerceProperty$Ex(Lit118, Lit15, Lit119, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit118, Lit39, Lit80, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit118, Lit71, Lit81, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit118, Lit41, "Actualiser l'humidité", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit118, Lit44, Lit120, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit118, Lit30, Lit31, Lit17);
    }

    static Object lambda39() {
        runtime.setAndCoerceProperty$Ex(Lit118, Lit15, Lit119, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit118, Lit39, Lit80, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit118, Lit71, Lit81, Lit17);
        runtime.setAndCoerceProperty$Ex(Lit118, Lit41, "Actualiser l'humidité", Lit14);
        runtime.setAndCoerceProperty$Ex(Lit118, Lit44, Lit120, Lit17);
        return runtime.setAndCoerceProperty$Ex(Lit118, Lit30, Lit31, Lit17);
    }

    public Object Button2$Click() {
        runtime.setThisForm();
        runtime.callComponentMethod(Lit84, Lit109, LList.list1("H"), Lit122);
        Scheme.applyToArgs.apply1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St));
        return runtime.setAndCoerceProperty$Ex(Lit65, Lit41, runtime.callYailPrimitive(strings.string$Mnappend, LList.list2(runtime.callComponentMethod(Lit84, Lit111, LList.list1(runtime.callComponentMethod(Lit84, Lit112, LList.Empty, LList.Empty)), Lit123), "%"), Lit124, "join"), Lit14);
    }

    public String getSimpleName(Object object) {
        return object.getClass().getSimpleName();
    }

    public void onCreate(Bundle icicle) {
        AppInventorCompatActivity.setClassicModeFromYail(true);
        super.onCreate(icicle);
    }

    public void androidLogForm(Object message) {
    }

    public void addToFormEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.form$Mnenvironment, object));
        this.form$Mnenvironment.put(name, object);
    }

    public Object lookupInFormEnvironment(Symbol name, Object default$Mnvalue) {
        boolean x = ((this.form$Mnenvironment == null ? 1 : 0) + 1) & true;
        if (x) {
            if (!this.form$Mnenvironment.isBound(name)) {
                return default$Mnvalue;
            }
        } else if (!x) {
            return default$Mnvalue;
        }
        return this.form$Mnenvironment.get(name);
    }

    public boolean isBoundInFormEnvironment(Symbol name) {
        return this.form$Mnenvironment.isBound(name);
    }

    public void addToGlobalVarEnvironment(Symbol name, Object object) {
        androidLogForm(Format.formatToString(0, "Adding ~A to env ~A with value ~A", name, this.global$Mnvar$Mnenvironment, object));
        this.global$Mnvar$Mnenvironment.put(name, object);
    }

    public void addToEvents(Object component$Mnname, Object event$Mnname) {
        this.events$Mnto$Mnregister = lists.cons(lists.cons(component$Mnname, event$Mnname), this.events$Mnto$Mnregister);
    }

    public void addToComponents(Object container$Mnname, Object component$Mntype, Object component$Mnname, Object init$Mnthunk) {
        this.components$Mnto$Mncreate = lists.cons(LList.list4(container$Mnname, component$Mntype, component$Mnname, init$Mnthunk), this.components$Mnto$Mncreate);
    }

    public void addToGlobalVars(Object var, Object val$Mnthunk) {
        this.global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(var, val$Mnthunk), this.global$Mnvars$Mnto$Mncreate);
    }

    public void addToFormDoAfterCreation(Object thunk) {
        this.form$Mndo$Mnafter$Mncreation = lists.cons(thunk, this.form$Mndo$Mnafter$Mncreation);
    }

    public void sendError(Object error) {
        RetValManager.sendError(error == null ? null : error.toString());
    }

    public void processException(Object ex) {
        Object apply1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(ex, Lit1));
        RuntimeErrorAlert.alert(this, apply1 == null ? null : apply1.toString(), ex instanceof YailRuntimeError ? ((YailRuntimeError) ex).getErrorType() : "Runtime Error", "End Application");
    }

    public boolean dispatchEvent(Component componentObject, String registeredComponentName, String eventName, Object[] args) {
        boolean x;
        SimpleSymbol registeredObject = misc.string$To$Symbol(registeredComponentName);
        if (!isBoundInFormEnvironment(registeredObject)) {
            EventDispatcher.unregisterEventForDelegation(this, registeredComponentName, eventName);
            return false;
        } else if (lookupInFormEnvironment(registeredObject) != componentObject) {
            return false;
        } else {
            try {
                Scheme.apply.apply2(lookupHandler(registeredComponentName, eventName), LList.makeList(args, 0));
                return true;
            } catch (PermissionException exception) {
                exception.printStackTrace();
                if (this == componentObject) {
                    x = true;
                } else {
                    x = false;
                }
                if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                    processException(exception);
                } else {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                }
                return false;
            } catch (Throwable exception2) {
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
                return false;
            }
        }
    }

    public void dispatchGenericEvent(Component componentObject, String eventName, boolean notAlreadyHandled, Object[] args) {
        Boolean bool;
        boolean x = true;
        Object handler = lookupInFormEnvironment(misc.string$To$Symbol(strings.stringAppend("any$", getSimpleName(componentObject), "$", eventName)));
        if (handler != Boolean.FALSE) {
            try {
                Apply apply = Scheme.apply;
                if (notAlreadyHandled) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                apply.apply2(handler, lists.cons(componentObject, lists.cons(bool, LList.makeList(args, 0))));
            } catch (PermissionException exception) {
                exception.printStackTrace();
                if (this != componentObject) {
                    x = false;
                }
                if (!x ? x : IsEqual.apply(eventName, "PermissionNeeded")) {
                    processException(exception);
                } else {
                    PermissionDenied(componentObject, eventName, exception.getPermissionNeeded());
                }
            } catch (Throwable exception2) {
                androidLogForm(exception2.getMessage());
                exception2.printStackTrace();
                processException(exception2);
            }
        }
    }

    public Object lookupHandler(Object componentName, Object eventName) {
        String str = null;
        String obj = componentName == null ? null : componentName.toString();
        if (eventName != null) {
            str = eventName.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(obj, str)));
    }

    public void $define() {
        Object reverse;
        Object obj;
        Object reverse2;
        Object obj2;
        Object obj3;
        Object var;
        Object component$Mnname;
        Object obj4;
        Language.setDefaults(Scheme.getInstance());
        try {
            run();
        } catch (Exception exception) {
            androidLogForm(exception.getMessage());
            processException(exception);
        }
        Main = this;
        addToFormEnvironment(Lit0, this);
        Object obj5 = this.events$Mnto$Mnregister;
        while (obj5 != LList.Empty) {
            try {
                Pair arg0 = (Pair) obj5;
                Object event$Mninfo = arg0.getCar();
                Object apply1 = lists.car.apply1(event$Mninfo);
                String obj6 = apply1 == null ? null : apply1.toString();
                Object apply12 = lists.cdr.apply1(event$Mninfo);
                EventDispatcher.registerEventForDelegation(this, obj6, apply12 == null ? null : apply12.toString());
                obj5 = arg0.getCdr();
            } catch (ClassCastException e) {
                WrongType wrongType = new WrongType(e, "arg0", -2, obj5);
                throw wrongType;
            }
        }
        try {
            LList components = lists.reverse(this.components$Mnto$Mncreate);
            addToGlobalVars(Lit2, lambda$Fn1);
            reverse = lists.reverse(this.form$Mndo$Mnafter$Mncreation);
            while (reverse != LList.Empty) {
                Pair arg02 = (Pair) reverse;
                misc.force(arg02.getCar());
                reverse = arg02.getCdr();
            }
            obj = components;
            while (obj != LList.Empty) {
                Pair arg03 = (Pair) obj;
                Object component$Mninfo = arg03.getCar();
                component$Mnname = lists.caddr.apply1(component$Mninfo);
                lists.cadddr.apply1(component$Mninfo);
                Object component$Mnobject = Invoke.make.apply2(lists.cadr.apply1(component$Mninfo), lookupInFormEnvironment((Symbol) lists.car.apply1(component$Mninfo)));
                SlotSet.set$Mnfield$Ex.apply3(this, component$Mnname, component$Mnobject);
                addToFormEnvironment((Symbol) component$Mnname, component$Mnobject);
                obj = arg03.getCdr();
            }
            reverse2 = lists.reverse(this.global$Mnvars$Mnto$Mncreate);
            while (reverse2 != LList.Empty) {
                Pair arg04 = (Pair) reverse2;
                Object var$Mnval = arg04.getCar();
                var = lists.car.apply1(var$Mnval);
                addToGlobalVarEnvironment((Symbol) var, Scheme.applyToArgs.apply1(lists.cadr.apply1(var$Mnval)));
                reverse2 = arg04.getCdr();
            }
            Object obj7 = components;
            obj2 = obj7;
            while (obj2 != LList.Empty) {
                Pair arg05 = (Pair) obj2;
                Object component$Mninfo2 = arg05.getCar();
                lists.caddr.apply1(component$Mninfo2);
                Object init$Mnthunk = lists.cadddr.apply1(component$Mninfo2);
                if (init$Mnthunk != Boolean.FALSE) {
                    Scheme.applyToArgs.apply1(init$Mnthunk);
                }
                obj2 = arg05.getCdr();
            }
            obj3 = obj7;
            while (obj3 != LList.Empty) {
                Pair arg06 = (Pair) obj3;
                Object component$Mninfo3 = arg06.getCar();
                Object component$Mnname2 = lists.caddr.apply1(component$Mninfo3);
                lists.cadddr.apply1(component$Mninfo3);
                callInitialize(SlotGet.field.apply2(this, component$Mnname2));
                obj3 = arg06.getCdr();
            }
        } catch (ClassCastException e2) {
            WrongType wrongType2 = new WrongType(e2, "arg0", -2, obj3);
            throw wrongType2;
        } catch (ClassCastException e3) {
            WrongType wrongType3 = new WrongType(e3, "arg0", -2, obj2);
            throw wrongType3;
        } catch (ClassCastException e4) {
            WrongType wrongType4 = new WrongType(e4, "add-to-global-var-environment", 0, var);
            throw wrongType4;
        } catch (ClassCastException e5) {
            WrongType wrongType5 = new WrongType(e5, "arg0", -2, reverse2);
            throw wrongType5;
        } catch (ClassCastException e6) {
            WrongType wrongType6 = new WrongType(e6, "add-to-form-environment", 0, component$Mnname);
            throw wrongType6;
        } catch (ClassCastException e7) {
            WrongType wrongType7 = new WrongType(e7, "lookup-in-form-environment", 0, obj4);
            throw wrongType7;
        } catch (ClassCastException e8) {
            WrongType wrongType8 = new WrongType(e8, "arg0", -2, obj);
            throw wrongType8;
        } catch (ClassCastException e9) {
            WrongType wrongType9 = new WrongType(e9, "arg0", -2, reverse);
            throw wrongType9;
        } catch (YailRuntimeError exception2) {
            processException(exception2);
        }
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object[] argsArray) {
        LList symbols = LList.makeList(argsArray, 0);
        Apply apply = Scheme.apply;
        ModuleMethod moduleMethod = strings.string$Mnappend;
        Object obj = LList.Empty;
        Object obj2 = symbols;
        while (obj2 != LList.Empty) {
            try {
                Pair arg0 = (Pair) obj2;
                Object arg02 = arg0.getCdr();
                Object car = arg0.getCar();
                try {
                    obj = Pair.make(misc.symbol$To$String((Symbol) car), obj);
                    obj2 = arg02;
                } catch (ClassCastException e) {
                    throw new WrongType(e, "symbol->string", 1, car);
                }
            } catch (ClassCastException e2) {
                throw new WrongType(e2, "arg0", -2, obj2);
            }
        }
        Object apply2 = apply.apply2(moduleMethod, LList.reverseInPlace(obj));
        try {
            return misc.string$To$Symbol((CharSequence) apply2);
        } catch (ClassCastException e3) {
            throw new WrongType(e3, "string->symbol", 1, apply2);
        }
    }

    static Object lambda2() {
        return null;
    }
}
