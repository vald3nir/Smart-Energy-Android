package com.vald3nir.smart_energy.presentation.historic.extensions

import androidx.recyclerview.widget.DiffUtil
import com.vald3nir.smart_energy.data.dtos.HistoricItemMenuDTO
import com.vald3nir.smart_energy.data.dtos.ItemMenuEnum
import com.vald3nir.smart_energy.databinding.ItemViewMenuHistoricBinding

fun ItemViewMenuHistoricBinding.bindItem(
    item: HistoricItemMenuDTO,
    redirectEnum: (enum: ItemMenuEnum) -> Unit
) {
    imvIcon.loadImage(placeholder = item.icon)
    txvTitle.text = root.context.getString(item.title)
    root.setOnClickListener { redirectEnum.invoke(item.item) }
}

fun historicItemMenuDiffUtil(): DiffUtil.ItemCallback<HistoricItemMenuDTO> =
    object : DiffUtil.ItemCallback<HistoricItemMenuDTO>() {

        override fun areItemsTheSame(
            oldItem: HistoricItemMenuDTO,
            newItem: HistoricItemMenuDTO
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: HistoricItemMenuDTO,
            newItem: HistoricItemMenuDTO
        ): Boolean {
            return oldItem == newItem
        }
    }

