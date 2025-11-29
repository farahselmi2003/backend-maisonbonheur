package com.maisonbonheur.perfumebackend.service;

import com.maisonbonheur.perfumebackend.entity.Cart;
import com.maisonbonheur.perfumebackend.entity.CartItem;
import com.maisonbonheur.perfumebackend.dto.request.CartRequest;

import java.util.List;

public interface CartService {
    Cart getCartByUserId(Long userId);
    Cart addItemToCart(Long userId, CartRequest cartRequest);
    Cart updateCartItem(Long userId, Long itemId, Integer quantity);
    Cart removeItemFromCart(Long userId, Long itemId);
    Cart clearCart(Long userId);
    CartItem getCartItemById(Long itemId);
    List<CartItem> getCartItemsByUserId(Long userId);
    Double calculateCartTotal(Long userId);
}