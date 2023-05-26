import React, { useContext } from 'react';
// import useParams
import { useParams } from 'react-router-dom';
// import cart context
import { CartContext } from '../contexts/CartContext';
// import product context
import { ProductContext } from '../contexts/ProductContext';

const ProductDetails = () => {
  // get the product id from the url
  const { id } = useParams();
  const { products } = useContext(ProductContext);
  const { addToCart } = useContext(CartContext);

  // get the single product based on the id
  const product = products.find((item) => {
    return item.id === parseInt(id);
  });

  // if product is not found
  if (!product) {
    return (
      <section className='h-screen flex justify-center items-center'>
        Loading...
      </section>
    );
  }

  // destructure product
  const { title, price, description, image, category } = product;
  return (
    <section className='pt-32 pb-12 lg:py-40 h-screen flex items-center'>
      <div className='container mx-auto'>
        {/* image & text wrapper */}
        <div className='flex flex-col lg:flex-row items-center'>
          {/* image */}
          <div className='flex flex-1 justify-center items-center mb-8 lg:mb-0'>
            <img className='max-w-[300px] border border-[#F9F9F9] p-5 lg:max-w-sm ' src={image} alt='' />
          </div>
          {/* text */}
          <div className='flex-1 text-center lg:text-left'>
            <h1 className='text-[26px] text-white font-medium mb-2 max-w-[500px] mx-auto lg:mx-0'>
              {title}
            </h1>
            <h1 className='text-[20px] text-gray-500 font-medium mb-5 max-w-[450px] mx-auto lg:mx-0'>
              {category}
            </h1>
            <p className='mb-8 text-white'>{description}</p>
            <div className='text-xl text-white font-medium mb-4'>
               {parseFloat(price).toFixed(2)+" LKR"}
            </div>
            <button
              onClick={() => addToCart(product, product.id)}
              className='bg-white py-4 px-8 text-dark mt-10'
            >
              Add to cart
            </button>
          </div>
        </div>
      </div>
    </section>
  );
};

export default ProductDetails;
