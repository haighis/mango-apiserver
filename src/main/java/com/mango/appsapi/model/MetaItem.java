// package com.openapi.model;

// import javax.persistence.*;

// /*
// *
// * */
// @Entity
// @Table(name = "meta_items")
// public class MetaItem extends BaseEntity {

// //	@Id
// //	@GeneratedValue(strategy = GenerationType.AUTO)
// //	private long id;

// 	@Column(name = "title")
// 	private String title;

// 	@Column(name = "item_type") // namespace, context, label
// 	private String itemType;

// 	public MetaItem() {

// 	}

// 	public MetaItem(String title, String item_type) {
// 		this.title = title;
// 		this.itemType = item_type;
// 	}

// //	public long getId() {
// //		return id;
// //	}

// 	public String getTitle() {
// 		return title;
// 	}

// 	public void setTitle(String title) {
// 		this.title = title;
// 	}

// 	public String getItemType() {
// 		return itemType;
// 	}

// 	public void setItemType(String itemType) {
// 		this.itemType = itemType;
// 	}

// 	@Override
// 	public String toString() {
// 		return "Tutorial [id=" + this.getId() + ", title=" + title + ", itemType=" + itemType + "]";
// 	}
// }
