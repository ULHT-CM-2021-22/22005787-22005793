// Generated by view binder compiler. Do not edit!
package pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pt.ulusofona.deisi.cm2122.g22005787_22005793.R;

public final class FragmentFiltersBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button buttonEstadoFogoFilter;

  @NonNull
  public final Button buttonMeiosFilter;

  @NonNull
  public final Button buttonRadiusFilter;

  @NonNull
  public final Button buttonRegionFilter;

  @NonNull
  public final Button buttonSubmit;

  @NonNull
  public final TextView distritoFiltros;

  @NonNull
  public final TextView fireState;

  @NonNull
  public final TextView meiosOperacionaisFiltros;

  @NonNull
  public final TextView raioPretendido;

  private FragmentFiltersBinding(@NonNull FrameLayout rootView,
      @NonNull Button buttonEstadoFogoFilter, @NonNull Button buttonMeiosFilter,
      @NonNull Button buttonRadiusFilter, @NonNull Button buttonRegionFilter,
      @NonNull Button buttonSubmit, @NonNull TextView distritoFiltros, @NonNull TextView fireState,
      @NonNull TextView meiosOperacionaisFiltros, @NonNull TextView raioPretendido) {
    this.rootView = rootView;
    this.buttonEstadoFogoFilter = buttonEstadoFogoFilter;
    this.buttonMeiosFilter = buttonMeiosFilter;
    this.buttonRadiusFilter = buttonRadiusFilter;
    this.buttonRegionFilter = buttonRegionFilter;
    this.buttonSubmit = buttonSubmit;
    this.distritoFiltros = distritoFiltros;
    this.fireState = fireState;
    this.meiosOperacionaisFiltros = meiosOperacionaisFiltros;
    this.raioPretendido = raioPretendido;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFiltersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFiltersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_filters, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFiltersBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_estadoFogo_filter;
      Button buttonEstadoFogoFilter = ViewBindings.findChildViewById(rootView, id);
      if (buttonEstadoFogoFilter == null) {
        break missingId;
      }

      id = R.id.button_meios_filter;
      Button buttonMeiosFilter = ViewBindings.findChildViewById(rootView, id);
      if (buttonMeiosFilter == null) {
        break missingId;
      }

      id = R.id.button_radius_filter;
      Button buttonRadiusFilter = ViewBindings.findChildViewById(rootView, id);
      if (buttonRadiusFilter == null) {
        break missingId;
      }

      id = R.id.button_region_filter;
      Button buttonRegionFilter = ViewBindings.findChildViewById(rootView, id);
      if (buttonRegionFilter == null) {
        break missingId;
      }

      id = R.id.button_submit;
      Button buttonSubmit = ViewBindings.findChildViewById(rootView, id);
      if (buttonSubmit == null) {
        break missingId;
      }

      id = R.id.distrito_filtros;
      TextView distritoFiltros = ViewBindings.findChildViewById(rootView, id);
      if (distritoFiltros == null) {
        break missingId;
      }

      id = R.id.fireState;
      TextView fireState = ViewBindings.findChildViewById(rootView, id);
      if (fireState == null) {
        break missingId;
      }

      id = R.id.meiosOperacionais_filtros;
      TextView meiosOperacionaisFiltros = ViewBindings.findChildViewById(rootView, id);
      if (meiosOperacionaisFiltros == null) {
        break missingId;
      }

      id = R.id.raio_pretendido;
      TextView raioPretendido = ViewBindings.findChildViewById(rootView, id);
      if (raioPretendido == null) {
        break missingId;
      }

      return new FragmentFiltersBinding((FrameLayout) rootView, buttonEstadoFogoFilter,
          buttonMeiosFilter, buttonRadiusFilter, buttonRegionFilter, buttonSubmit, distritoFiltros,
          fireState, meiosOperacionaisFiltros, raioPretendido);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
