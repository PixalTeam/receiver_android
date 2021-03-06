package gnu.mapping;

import java.lang.ref.WeakReference;

/* compiled from: Namespace */
class SymbolRef extends WeakReference {
    SymbolRef next;

    SymbolRef(Symbol sym, Namespace ns) {
        super(sym);
    }

    /* access modifiers changed from: 0000 */
    public Symbol getSymbol() {
        return (Symbol) get();
    }

    public String toString() {
        return "SymbolRef[" + getSymbol() + "]";
    }
}
