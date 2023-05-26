import React from 'react';
// import images
import Img from '../img/hero.png';
// import link
import { Link } from 'react-router-dom';

const Hero = () => {
  return (
    <section className='h-[800px] bg-hero bg-no-repeat bg-cover bg-center py-24'>
      <div className='container mx-auto flex justify-around h-full'>
        {/* text */}
        <div className='flex flex-col justify-center'>
          {/* pretitle */}
          <div className='font-semibold flex items-center uppercase mb-4 text-white'>
            <div className='w-10 h-[2px] bg-white mr-3 text-white '></div>PC Parts
          </div>
          {/* title */}
          <h1 className='text-[45px] leading-[1.1] text-white mb-4'>
          BUILD IT WITH THE BEST PLACE IN TOWN<br />
            <span className='font-semibold text-white mb-4'>Bumble Bee</span>
          </h1>
          <Link
            to={'/home'}
            className='self-start text-white uppercase font-semibold border-b-2 border-light'
          >
            Shop Now
          </Link>
        </div>
        {/* image */}
        <div className='hidden lg:block'>
          <img src={Img} alt='' />
        </div>
      </div>
    </section>
  );
};

export default Hero;
