package pt.ulusofona.deisi.cm2122.g22005787_22005793

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.ulusofona.deisi.cm2122.g22005787_22005793.databinding.ItemExpressionBinding

class FireAdapter(
    private var items: List<FireData> = listOf(),
    private val onClick: (FireData) -> Unit,
    private val onLongClick: (FireData) -> Boolean
) : RecyclerView.Adapter<FireAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(val binding: ItemExpressionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemExpressionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.binding.textTitle.text = items[position].distrito
        holder.binding.textInf.text =
            "Concelho -> ${items[position].concelho ?: "Informação não disponível"}" +
                    " \nFreguesia -> ${items[position].freguesia ?: "Informação não disponível"} \n" +
                    "Estado -> ${items[position].estado ?: "Informação não disponível"}" +
                    " \nData -> ${items[position].data ?: "Informação não disponível"}"
        holder.itemView.setOnClickListener { onClick(items[position]) }
        holder.itemView.setOnLongClickListener { onLongClick(items[position]) }
    }

    override fun getItemCount() = items.size

    fun updateItems(items: List<FireData>) {
        this.items = items
        notifyDataSetChanged()
    }


}
