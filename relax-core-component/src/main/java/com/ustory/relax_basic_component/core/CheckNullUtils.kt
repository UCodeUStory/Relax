package relax_basic_component.core

fun <P1, P2> bothNotNull(p1: P1?, p2: P2?, execute: (P1, P2) -> Unit) {
    if (p1 != null && p2 != null) {
        execute(p1, p2)
    }
}

fun <P1, P2, P3> bothNotNull(p1: P1?, p2: P2?, p3: P3, execute: (P1, P2, P3) -> Unit) {
    if (p1 != null && p2 != null && p3 != null) {
        execute(p1, p2, p3)
    }
}

fun <P1, P2, P3, P4> bothNotNull(
    p1: P1?,
    p2: P2?,
    p3: P3,
    p4: P4,
    execute: (P1, P2, P3, P4) -> Unit
) {
    if (p1 != null && p2 != null && p3 != null && p4 != null) {
        execute(p1, p2, p3, p4)
    }
}
