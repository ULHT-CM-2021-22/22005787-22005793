package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\r\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0010\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nJ\u001a\u0010\u0011\u001a\u00020\u000f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0012J\"\u0010\u0011\u001a\u00020\u000f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\u0011\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014\u00a2\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\b0\u0012J\u0006\u0010\u0019\u001a\u00020\u000fJ\u001a\u0010\u001a\u001a\u00020\u000f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0012J\u001a\u0010\u001b\u001a\u00020\u000f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "model", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireModel;", "onAddToHistory", "", "onFinished", "Lkotlin/Function0;", "fireData", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireRoom;", "onAlterarRegiao", "regiao", "", "onAlterarRisco", "onFogosNaRegiao", "Lkotlin/Function1;", "onGetDistricts", "", "()[Ljava/lang/String;", "onGetHistory", "", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireData;", "onGetRisk", "onMediaFogosNaRegiao", "onTotalFogos", "app_debug"})
public final class FireViewModel extends androidx.lifecycle.AndroidViewModel {
    private final pt.ulusofona.deisi.cm2122.g22005787_22005793.FireModel model = null;
    
    public FireViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    public final void onGetHistory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData>, kotlin.Unit> onFinished) {
    }
    
    public final void onAddToHistory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    pt.ulusofona.deisi.cm2122.g22005787_22005793.FireRoom fireData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onFogosNaRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onFogosNaRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onTotalFogos(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onMediaFogosNaRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onFinished) {
        return null;
    }
    
    public final void onAlterarRegiao(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished, @org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
    }
    
    public final void onAlterarRisco(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onFinished) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String onGetRisk() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] onGetDistricts() {
        return null;
    }
}