.class public aval4
.super java/lang/Object

.method public static f(II)I
.limit locals 3
.limit stack 2
iconst_0
istore_2
loop0:

iload_0
iload_1
if_icmpge loop0_end

invokestatic io/read()I

istore_2

invokestatic io/read()I

istore_0

iload_0
iload_2
iadd
istore_0

goto loop0

loop0_end:
iload_2
ireturn
.end method

.method public static main([Ljava/lang/String;)V
.limit locals 1
.limit stack 2
iconst_5
bipush 6
invokestatic aval4/f(II)I

istore_0

iload_0
invokestatic io/println(I)V
return
.end method


.method static public <clinit>()V
.limit locals 0
.limit stack 1 
return
.end method

