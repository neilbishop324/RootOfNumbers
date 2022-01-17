import java.util.*;

class roots
{

	public static int findGCD(int a , int b)
	{

		if (b == 0)
		{
			return a;
		}

		return findGCD(b , a % b);

	}


	public static void main(String[] args)
	{
		// Z ints

		int x = 2;
		int indexZ;
		int innerI;
		int outerI;
		int innerM = 1;
		int outerM = 1;

		// Q ints numerator

		int numerator;
		int numerIn = 1;
		int numerOut = 1;
		int y = 2;
		int indexQ;
		int numerInI , numerOutI;

		// Q ints denominator

		int denominator;
		int denomPow = 0;
		int denomIn , denomOut;

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a number: √ ");
		double input1 = input.nextDouble();

		System.out.print("Enter a root number : ");
		int input2 = input.nextInt();

		///////////////////////////////////////////

		if (input1 % 1 != 0)
		{

			for (; input1 % 1 != 0 ; denomPow++)
			{

				input1 *= 10;

			}

			numerator = (int) input1;

			denominator = (int) Math.pow(10, denomPow);

			if (input1 < 0 && input2 % 2 == 0)
			{System.out.println("An even root cannot take a negative value!");}

			else
			{

				if (input2 < 1)
				{System.out.println("A root number can not be less than 1!");}

				else if (input2 == 1)
				{
					System.out.println("Result : " + numerator + " / " + denominator); 
				}

			 	else
				{

					while (true)
					{

						indexQ = 0;

						if (numerator != 1)
						{

						 	if (numerator % y == 0)
							{


							 	for (; numerator % y == 0 ; indexQ++)
								{

									numerator /= y; }

								if (indexQ >= input2)
								{

									numerOutI = indexQ / input2;
									numerInI = indexQ % input2;

								}

								else
								{

									numerOutI = 0;
									numerInI = indexQ;

								} 

								numerIn *= Math.pow(y, numerInI);

								numerOut *= Math.pow(y, numerOutI);

								y++;

							 	if (numerator == 1 || numerator == -1)
								{break;}
							}

							else if (numerator % y != 0)
							{y++;}

							else
							{break;}  }

						else
						{break;}


					}

					denomIn = (int) Math.pow(10 , denomPow % input2);

					denomOut = (int) Math.pow(10 , denomPow / input2);

					int outGCD = findGCD(numerOut , denomOut);

					int inGCD = findGCD(numerIn , denomIn);

					numerOut /= outGCD;
					denomOut /= outGCD;
					numerIn /= inGCD;
					denomIn /= inGCD;



					if (input2 == 2)
					{

						if (numerIn == 1)
						{

							if (numerator > 0)
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + numerOut + " / " + denomOut);
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + numerOut + " / " + " √ " + denomIn);
								}
								else
								{
									System.out.println("Result : " + numerOut + " / " + denomOut + " √ " + denomIn);
								}
							}


							else
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + "- " + numerOut + " / " + denomOut);
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + "- " + numerOut + " / " + " √ " + denomIn);
								}
								else
								{
									System.out.println("Result : " + "- " + numerOut + " / " + denomOut + " √ " + denomIn);
								}
							}

						}

						else if (numerOut == 1)
						{

							if (numerator > 0)
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + " √ " + numerIn + " / " + denomOut);
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + " √ " + numerIn + " / " + " √ " + denomIn);
								}
								else
								{
									System.out.println("Result : " + " √ " + numerIn + " / " + denomOut + " √ " + denomIn);
								}
							}


							else
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + "- √ " + numerIn + " / " + denomOut);
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + "- √ " + numerIn + " / " + " √ " + denomIn);
								}
								else
								{
									System.out.println("Result : " + "- √ " + numerIn + " / " + denomOut + " √ " + denomIn);
								}
							}

						}

						else
						{

							if (numerator > 0)
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + numerOut + " √ " + numerIn + " / " + denomOut);
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + numerOut + " √ " + numerIn + " / √ " + denomIn);
								}
								else
								{
									System.out.println("Result : " + numerOut + " √ " + numerIn + " / " + denomOut + " √ " + denomIn);
								}
							}
							else
							{
								if (denomIn == 1)
								{
									System.out.println("Result : " + "- " + numerOut + " √ " + numerIn + " / " + denomOut);
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + "- " + numerOut + " √ " + numerIn + " / √ " + denomIn);
								}
								else
								{
									System.out.println("Result : " + "- " + numerOut + " √ " + numerIn + " / " + denomOut + " √ " + denomIn);
								}
							}

						}

					}

					else
					{

						if (numerIn == 1)
						{

							if (numerator > 0)
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + numerOut + " / " + denomOut + " (" + input2 + ")");
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + numerOut + " / " + "√ " + denomIn + " (" + input2 + ")");
								}
								else
								{
									System.out.println("Result : " + numerOut + " / " + denomOut + " √ " + denomIn + " (" + input2 + ")");
								}
							}


							else
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + "- " + numerOut + " / " + denomOut + " (" + input2 + ")");
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + "- " + numerOut + " / " + "√ " + denomIn + " (" + input2 + ")");
								}
								else
								{
									System.out.println("Result : " + "- " + numerOut + " / " + denomOut + " √ " + denomIn + " (" + input2 + ")");
								}
							}

						}

						else if (numerOut == 1)
						{

							if (numerator > 0)
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + " √ " + numerIn + " / " + denomOut + " (" + input2 + ")");
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + " √ " + numerIn + " / " + " √ " + denomIn + " (" + input2 + ")");
								}
								else
								{
									System.out.println("Result : " + " √ " + numerIn + " / " + denomOut + " √ " + denomIn + " (" + input2 + ")");
								}
							}


							else
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + "- √ " + numerIn + " / " + denomOut + " (" + input2 + ")");
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + "- √ " + numerIn + " / " + "√ " + denomIn + " (" + input2 + ")");
								}
								else
								{
									System.out.println("Result : " + "- √ " + numerIn + " / " + denomOut + " √ " + denomIn + " (" + input2 + ")");
								}
							}

						}

						else
						{

							if (numerator > 0)
							{

								if (denomIn == 1)
								{
									System.out.println("Result : " + numerOut + " √ " + numerIn + " / " + denomOut + " (" + input2 + ")");
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + numerOut + " √ " + numerIn + " / √ " + denomIn + " (" + input2 + ")");
								}
								else
								{
									System.out.println("Result : " + numerOut + " √ " + numerIn + " / " + denomOut + " √ " + denomIn + " (" + input2 + ")");
								}
							}
							else
							{
								if (denomIn == 1)
								{
									System.out.println("Result : " + "-" + numerOut + " √ " + numerIn + " / " + denomOut + " (" + input2 + ")");
								}
								else if (denomOut == 1)
								{
									System.out.println("Result : " + "-" + numerOut + " √ " + numerIn + " / √ " + denomIn + " (" + input2 + ")");
								}
								else
								{
									System.out.println("Result : " + "-" + numerOut + " √ " + numerIn + " / " + denomOut + " √ " + denomIn + " (" + input2 + ")");
								}
							}

						}

					}

				}


			}

		}
		///////////////////////////////////////////

		else
		{

			int input3 = (int) Math.round(input1);

			if (input3 == 0)
			{System.out.println("Result : " + 0);}

			else if (input3 == 1)
			{System.out.println("Result : " + 1);}

			else if (input3 < 0 && input2 % 2 == 0)
			{

				System.out.println("An even root cannot take a negative value!"); }

			else
			{

				if (input2 < 1)
				{System.out.println("A root number can not be less than 1!");}

				else if (input2 == 1)
				{System.out.println("Result : " + input3);}

				else
				{

					while (true)
					{

						indexZ = 0;

						if (input3 % x == 0)
						{


							for (; input3 % x == 0 ; indexZ++)
							{

								input3 /= x; }

							if (indexZ >= input2)
							{

								outerI = indexZ / input2;
								innerI = indexZ % input2;

							}

							else
							{

								outerI = 0;
								innerI = indexZ;

							}

							innerM *= Math.pow(x, innerI);

							outerM *= Math.pow(x, outerI);

							x++;

							if (input3 == 1 || input3 == -1)
							{break;}

						}

						else if (input3 % x != 0)
						{x++;}

						else
						{break;}


					}

					if (input2 == 2)
					{

						if (innerM == 1)
						{

							if (input3 > 0)
							{System.out.println("Result : " + outerM);}
							else
							{System.out.println("Result : -" + outerM);}

						}

						else if (outerM == 1)
						{

							if (input3 > 0)
							{System.out.println("Result : " + " √ " + innerM);}
							else
							{System.out.println("Result : - " + " √ " + innerM);}

						}

						else
						{

							if (input3 > 0)
							{System.out.println("Result : " +  outerM + " √ " + innerM);}
							else
							{System.out.println("Result : -" +  outerM + " √ " + innerM);}

						}

					}

					else
					{

						if (innerM == 1)
						{

							if (input3 > 0)
							{System.out.println("Result : " + outerM);}
							else
							{System.out.println("Result : -" + outerM);}

						}

						else if (outerM == 1)
						{

							if (input3 > 0)
							{System.out.println("Result : " + " √ " + innerM + " (" + input2 + ")");}
							else
							{System.out.println("Result : - " + " √ " + innerM + " (" + input2 + ")");}

						}

						else
						{

							if (input3 > 0)
							{System.out.println("Result : " +  outerM + " √ " + innerM  + " (" + input2 + ")");}
							else
							{System.out.println("Result : -" +  outerM + " √ " + innerM  + " (" + input2 + ")");}

						}  

					}

				}

			}

		}

	}
}

