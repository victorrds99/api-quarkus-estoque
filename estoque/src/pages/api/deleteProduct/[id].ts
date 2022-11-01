import axios from 'axios';
import { NextApiRequest, NextApiResponse } from 'next';

const deleteProdut = async (req: NextApiRequest, res: NextApiResponse) => {
  const { id } = req.query;
  if (req.method === 'DELETE') {
    try {
      const { data } = await axios.delete(`http://my-quarkus-app:8080/produto/${id}`, {
        headers: {
          accept: 'application/json',
        },
      });

      return res.status(200).json(data);
    } catch (error) {
      return res.status(500).send('Internal server error');
    }
  }

  res.setHeader('Allow', 'DELETE');
  return res.status(405).end('Method not allowed');
};

export default deleteProdut;
