.class public aval1
.super java/lang/Object

.method public static main([Ljava/lang/String;)V
.limit locals 10
.limit stack 10
invokestatic aval1/f(II)I
istore_0
invokestatic io/println(I)V
return
.end method

.method public static f(II)I
.limit locals 10
.limit stack 10
iload_0
iload_1
imul
istore_2
iload_2
ireturn
.end method


.met.method static public <clinit>()V
.limit stack 0
.limit locals 0
return
.end method

