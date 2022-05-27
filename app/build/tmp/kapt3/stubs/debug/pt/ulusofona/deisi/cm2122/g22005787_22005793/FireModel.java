package pt.ulusofona.deisi.cm2122.g22005787_22005793;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005J \u0010\u001f\u001a\u00020\u00192\u0018\u0010 \u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\"\u0012\u0004\u0012\u00020\u00190!J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020\u0005R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014\u00a8\u0006\'"}, d2 = {"Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireModel;", "", "()V", "districts", "", "", "getDistricts", "()[Ljava/lang/String;", "[Ljava/lang/String;", "list", "Ljava/util/ArrayList;", "Lpt/ulusofona/deisi/cm2122/g22005787_22005793/FireData;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "region", "getRegion", "()Ljava/lang/String;", "setRegion", "(Ljava/lang/String;)V", "risk", "getRisk", "setRisk", "addToHistory", "", "fireData", "alterarRegiao", "regiao", "alterarRisco", "fogosNaRegiao", "getHistory", "onFinished", "Lkotlin/Function1;", "", "infNotAvailable", "view", "mediaFogosNaRegiao", "totalFogos", "app_debug"})
public final class FireModel {
    @org.jetbrains.annotations.NotNull()
    public static final pt.ulusofona.deisi.cm2122.g22005787_22005793.FireModel INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String region = "Lisboa";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String risk;
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData> list;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] districts = {"Aveiro", "Beja", "Braga", "Bragan\u00e7a", "Castelo Branco", "Coimbra", "\u00c9vora", "Faro", "Guarda", "Leiria", "Lisboa", "Portalegre", "Porto", "Santar\u00e9m", "Set\u00fabal", "Viana do Castelo", "Vila Real", "Viseu"};
    
    private FireModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRegion() {
        return null;
    }
    
    public final void setRegion(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRisk() {
        return null;
    }
    
    public final void setRisk(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getDistricts() {
        return null;
    }
    
    public final void getHistory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData>, kotlin.Unit> onFinished) {
    }
    
    public final void addToHistory(@org.jetbrains.annotations.NotNull()
    pt.ulusofona.deisi.cm2122.g22005787_22005793.FireData fireData) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String infNotAvailable(@org.jetbrains.annotations.NotNull()
    java.lang.String view) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fogosNaRegiao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String fogosNaRegiao(@org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String totalFogos() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String mediaFogosNaRegiao() {
        return null;
    }
    
    public final void alterarRegiao(@org.jetbrains.annotations.NotNull()
    java.lang.String regiao) {
    }
    
    public final void alterarRisco() {
    }
}