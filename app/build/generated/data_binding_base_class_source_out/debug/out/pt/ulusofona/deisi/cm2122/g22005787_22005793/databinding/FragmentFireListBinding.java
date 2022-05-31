// Generated by view binder compiler. Do not edit!
package pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import pt.ulusofona.deisi.cm2122.g22005787_22005793.R;

public final class FragmentFireListBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FloatingActionButton filter;

  @NonNull
  public final RecyclerView fireList;

  @NonNull
  public final ImageView imageview4;

  @NonNull
  public final TextView riscoRegiao;

  @NonNull
  public final RelativeLayout riskLayout;

  @NonNull
  public final TextView textNoHistoryAvailable;

  private FragmentFireListBinding(@NonNull FrameLayout rootView,
      @NonNull FloatingActionButton filter, @NonNull RecyclerView fireList,
      @NonNull ImageView imageview4, @NonNull TextView riscoRegiao,
      @NonNull RelativeLayout riskLayout, @NonNull TextView textNoHistoryAvailable) {
    this.rootView = rootView;
    this.filter = filter;
    this.fireList = fireList;
    this.imageview4 = imageview4;
    this.riscoRegiao = riscoRegiao;
    this.riskLayout = riskLayout;
    this.textNoHistoryAvailable = textNoHistoryAvailable;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFireListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFireListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_fire_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFireListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.filter;
      FloatingActionButton filter = ViewBindings.findChildViewById(rootView, id);
      if (filter == null) {
        break missingId;
      }

      id = R.id.fire_list;
      RecyclerView fireList = ViewBindings.findChildViewById(rootView, id);
      if (fireList == null) {
        break missingId;
      }

      id = R.id.imageview4;
      ImageView imageview4 = ViewBindings.findChildViewById(rootView, id);
      if (imageview4 == null) {
        break missingId;
      }

      id = R.id.risco_regiao;
      TextView riscoRegiao = ViewBindings.findChildViewById(rootView, id);
      if (riscoRegiao == null) {
        break missingId;
      }

      id = R.id.risk_layout;
      RelativeLayout riskLayout = ViewBindings.findChildViewById(rootView, id);
      if (riskLayout == null) {
        break missingId;
      }

      id = R.id.textNoHistoryAvailable;
      TextView textNoHistoryAvailable = ViewBindings.findChildViewById(rootView, id);
      if (textNoHistoryAvailable == null) {
        break missingId;
      }

      return new FragmentFireListBinding((FrameLayout) rootView, filter, fireList, imageview4,
          riscoRegiao, riskLayout, textNoHistoryAvailable);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
