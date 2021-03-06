package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.List;

public class LList extends ExtSequence implements Sequence, Externalizable, Comparable {
    public static final LList Empty = new LList();

    public static int listLength(Object obj, boolean allowOtherSequence) {
        int n = 0;
        Object slow = obj;
        Object fast = obj;
        while (fast != Empty) {
            if (fast instanceof Pair) {
                Pair fast_pair = (Pair) fast;
                if (fast_pair.cdr == Empty) {
                    return n + 1;
                }
                if (fast == slow && n > 0) {
                    return -1;
                }
                if (!(fast_pair.cdr instanceof Pair)) {
                    n++;
                    fast = fast_pair.cdr;
                } else if (!(slow instanceof Pair)) {
                    return -2;
                } else {
                    slow = ((Pair) slow).cdr;
                    fast = ((Pair) fast_pair.cdr).cdr;
                    n += 2;
                }
            } else if (!(fast instanceof Sequence) || !allowOtherSequence) {
                return -2;
            } else {
                int j = ((Sequence) fast).size();
                if (j >= 0) {
                    j += n;
                }
                return j;
            }
        }
        return n;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public int compareTo(Object obj) {
        return obj == Empty ? 0 : -1;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public SeqPosition getIterator(int index) {
        return new LListPosition(this, index, false);
    }

    public int createPos(int index, boolean isAfter) {
        return PositionManager.manager.register(new LListPosition(this, index, isAfter));
    }

    public int createRelativePos(int pos, int delta, boolean isAfter) {
        boolean old_after = isAfterPos(pos);
        if (delta < 0 || pos == 0) {
            return super.createRelativePos(pos, delta, isAfter);
        }
        if (delta == 0) {
            if (isAfter == old_after) {
                return copyPos(pos);
            }
            if (isAfter && !old_after) {
                return super.createRelativePos(pos, delta, isAfter);
            }
        }
        if (pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        LListPosition old = (LListPosition) PositionManager.getPositionObject(pos);
        if (old.xpos == null) {
            return super.createRelativePos(pos, delta, isAfter);
        }
        LListPosition it = new LListPosition(old);
        int it_ipos = it.ipos;
        if (isAfter && !old_after) {
            delta--;
            it_ipos += 3;
        }
        if (!isAfter && old_after) {
            delta++;
            it_ipos -= 3;
        }
        for (Object it_xpos = it.xpos; it_xpos instanceof Pair; it_xpos = ((Pair) it_xpos).cdr) {
            delta--;
            if (delta < 0) {
                it.ipos = it_ipos;
                it.xpos = it_xpos;
                return PositionManager.manager.register(it);
            }
            it_ipos += 2;
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean hasNext(int ipos) {
        return false;
    }

    public int nextPos(int ipos) {
        return 0;
    }

    public Object getPosNext(int ipos) {
        return eofValue;
    }

    public Object getPosPrevious(int ipos) {
        return eofValue;
    }

    /* Debug info: failed to restart local var, previous not found, register: 1 */
    /* access modifiers changed from: protected */
    public void setPosNext(int ipos, Object value) {
        if (ipos > 0) {
            PositionManager.getPositionObject(ipos).setNext(value);
        } else if (ipos == -1 || !(this instanceof Pair)) {
            throw new IndexOutOfBoundsException();
        } else {
            ((Pair) this).car = value;
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 1 */
    /* access modifiers changed from: protected */
    public void setPosPrevious(int ipos, Object value) {
        if (ipos > 0) {
            PositionManager.getPositionObject(ipos).setPrevious(value);
        } else if (ipos == 0 || !(this instanceof Pair)) {
            throw new IndexOutOfBoundsException();
        } else {
            ((Pair) this).lastPair().car = value;
        }
    }

    public Object get(int index) {
        throw new IndexOutOfBoundsException();
    }

    public static final int length(Object arg) {
        int count = 0;
        while (arg instanceof Pair) {
            count++;
            arg = ((Pair) arg).cdr;
        }
        return count;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [gnu.lists.LList] */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [gnu.lists.LList] */
    /* JADX WARNING: type inference failed for: r1v1, types: [gnu.lists.Pair] */
    /* JADX WARNING: type inference failed for: r2v0, types: [gnu.lists.Pair, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.Object>, for r6v0, types: [java.util.List, java.util.List<java.lang.Object>] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r3v2
  assigns: []
  uses: []
  mth insns count: 17
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 6 */
    public static LList makeList(List<Object> vals) {
        ? r3;
        ? r32 = Empty;
        ? r1 = 0;
        for (Object pair : vals) {
            ? pair2 = new Pair(pair, Empty);
            if (r1 == 0) {
                r3 = pair2;
            } else {
                r1.cdr = pair2;
                r3 = r32;
            }
            r1 = pair2;
            r32 = r3;
        }
        return r32;
    }

    public static LList makeList(Object[] vals, int offset, int length) {
        LList result = Empty;
        int i = length;
        while (true) {
            LList result2 = result;
            i--;
            if (i < 0) {
                return result2;
            }
            result = new Pair(vals[offset + i], result2);
        }
    }

    public static LList makeList(Object[] vals, int offset) {
        LList result = Empty;
        int i = vals.length - offset;
        while (true) {
            LList result2 = result;
            i--;
            if (i < 0) {
                return result2;
            }
            result = new Pair(vals[offset + i], result2);
        }
    }

    public void consume(Consumer out) {
        Object obj = this;
        out.startElement("list");
        while (obj instanceof Pair) {
            if (obj != this) {
                out.write(32);
            }
            Pair pair = (Pair) obj;
            out.writeObject(pair.car);
            obj = pair.cdr;
        }
        if (obj != Empty) {
            out.write(32);
            out.write(". ");
            out.writeObject(checkNonList(obj));
        }
        out.endElement();
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    }

    public void writeExternal(ObjectOutput out) throws IOException {
    }

    public Object readResolve() throws ObjectStreamException {
        return Empty;
    }

    public static Pair list1(Object arg1) {
        return new Pair(arg1, Empty);
    }

    public static Pair list2(Object arg1, Object arg2) {
        return new Pair(arg1, new Pair(arg2, Empty));
    }

    public static Pair list3(Object arg1, Object arg2, Object arg3) {
        return new Pair(arg1, new Pair(arg2, new Pair(arg3, Empty)));
    }

    public static Pair list4(Object arg1, Object arg2, Object arg3, Object arg4) {
        return new Pair(arg1, new Pair(arg2, new Pair(arg3, new Pair(arg4, Empty))));
    }

    public static Pair chain1(Pair old, Object arg1) {
        Pair p1 = new Pair(arg1, Empty);
        old.cdr = p1;
        return p1;
    }

    public static Pair chain4(Pair old, Object arg1, Object arg2, Object arg3, Object arg4) {
        Pair p4 = new Pair(arg4, Empty);
        old.cdr = new Pair(arg1, new Pair(arg2, new Pair(arg3, p4)));
        return p4;
    }

    public static LList reverseInPlace(Object list) {
        LList prev = Empty;
        while (list != Empty) {
            Pair pair = (Pair) list;
            list = pair.cdr;
            pair.cdr = prev;
            prev = pair;
        }
        return prev;
    }

    public static Object listTail(Object list, int count) {
        while (true) {
            count--;
            if (count < 0) {
                return list;
            }
            if (!(list instanceof Pair)) {
                throw new IndexOutOfBoundsException("List is too short.");
            }
            list = ((Pair) list).cdr;
        }
    }

    public static Object consX(Object[] args) {
        Object first = args[0];
        int n = args.length - 1;
        if (n <= 0) {
            return first;
        }
        Object result = new Pair(first, null);
        Pair prev = result;
        for (int i = 1; i < n; i++) {
            Pair next = new Pair(args[i], null);
            prev.cdr = next;
            prev = next;
        }
        prev.cdr = args[n];
        return result;
    }

    public String toString() {
        Object obj = this;
        int i = 0;
        StringBuffer sbuf = new StringBuffer(100);
        sbuf.append('(');
        while (true) {
            if (obj == Empty) {
                break;
            }
            if (i > 0) {
                sbuf.append(' ');
            }
            if (i < 10) {
                if (!(obj instanceof Pair)) {
                    sbuf.append(". ");
                    sbuf.append(checkNonList(obj));
                    break;
                }
                Pair pair = (Pair) obj;
                sbuf.append(pair.car);
                obj = pair.cdr;
                i++;
            } else {
                sbuf.append("...");
                break;
            }
        }
        sbuf.append(')');
        return sbuf.toString();
    }

    public static Object checkNonList(Object rest) {
        return rest instanceof LList ? "#<not a pair>" : rest;
    }
}
